package 주식가격;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 주식가격_동현 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int price[];
        int ans[];

        price = new int[]{1, 2, 3, 2, 3};
        ans = new int[]{4, 3, 1, 1, 0};
        assertThat(solution.solution(price)).isEqualTo(ans);

        price = new int[]{1, 1, 1, 1, 1};
        ans = new int[]{4, 3, 2, 1, 0};
        assertThat(solution.solution(price)).isEqualTo(ans);
    }

    static class Solution {
        public int[] solution(int[] prices) {
            List<Integer> answer = new ArrayList<>();
            int day;

            for (int i = 0; i < prices.length-1; i++) {
                day = 1;
                for(int j = i+1; j < prices.length-1; j++){
                    if(prices[i] > prices[j]) {
                        if (day < 2)
                            day = 1;
                        break;
                    }
                        day++;
                }
                answer.add(day);
            }
            answer.add(0);
            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}
