package 프로그래머스.위장;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
public class 위장_장호 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] clothes;
        int ans;

        clothes =new String[][]{{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        ans = 5;
        assertThat(solution.solution(clothes)).isEqualTo(ans);

        clothes =new String[][]{{"crow_mask", "face"},{"crow_mask", "face"},{"crow_mask", "face"}};
        ans = 3;
        assertThat(solution.solution(clothes)).isEqualTo(ans);

        clothes =new String[][]{{"crow_mask", "신발"},{"crow_mask1", "모자"}, {"crow_mask2", "모자"}, {"crow_mask1", "옷"}, {"crow_mask2", "옷"}, {"crow_mask3", "옷"}};
        ans = 23;
        assertThat(solution.solution(clothes)).isEqualTo(ans);

    }

    /*
     * 조합 & 순열문제
     * ex)
     * 옷의 종류가 {신발: 1개, 모자: 2개, 옷: 3개} 있다고 가정했을 때
     * 1개 입는 경우 [신발 + 모자1 + 모자2 + 옷1 + 옷2 + 옷3] => 총 6개
     * 2개 입는 경우 [신발(1) * 모자(2)] + [신발(1) * 옷(3)] + [모자(2) * 옷(3)] => 총 11개
     * 3개 입는 경우 [신발(1) * 모자(2) * 옷(3)] => 총 6개
     */
    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String, Integer> clothesCount = new HashMap<>();

            // key: 옷의 카테고리 value: 개수를 Map에 저장
            for (int i = 0; i < clothes.length; i++) {
                if (clothesCount.containsKey(clothes[i][1])) {
                    clothesCount.replace(clothes[i][1], clothesCount.get(clothes[i][1]) + 1);
                } else {
                    clothesCount.put(clothes[i][1], 1);
                }
            }

            // ((신발의 개수 + 1) * (모자의 개수 + 1) + (옷의 개수 + 1)) -1
            // 각각에 +1을 해준 이유는 해당 옷을 안입는 경우에 수를 더해준 것임
            // 이 부분이 이해가 잘 안됨
            for (int cnt : clothesCount.values()) {
                answer *= (cnt + 1);
            }
            return answer-1;
        }
    }
}
