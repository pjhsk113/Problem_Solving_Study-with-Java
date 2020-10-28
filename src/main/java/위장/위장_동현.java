package 위장;

import static org.assertj.core.api.Assertions.assertThat;
public class 위장_동현 {

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

    }

   static class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;
            return answer;
        }
    }
}
