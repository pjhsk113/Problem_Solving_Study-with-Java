package 프로그래머스.위장;

import java.util.HashMap;
import java.util.Map;

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
            int answer = 1;
            Map<String,Integer> map = new HashMap<>();

            for(int i = 0; i<clothes.length; i++) {
                map.put(clothes[i][1],0);
            }

            for(int i = 0; i<clothes.length; i++) {
                String kind = clothes[i][1];
                Integer count = map.get(kind);
                map.put(kind,count+1);
            }

//            System.out.println(map.toString());z

            if(map.size() == 1)
                return clothes.length;

            for (String key: map.keySet()) {
                answer*= map.get(key);
            }

            return answer+clothes.length;
        }
    }
}
