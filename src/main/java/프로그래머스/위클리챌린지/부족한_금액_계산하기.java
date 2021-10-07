package 프로그래머스.위클리챌린지;

import static org.assertj.core.api.Assertions.assertThat;

public class 부족한_금액_계산하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int price;
        int money;
        int count;
        int result;

        price = 3;
        money= 20;
        count= 4;
        result = 10;

        assertThat(solution.solution(price, money, count)).isEqualTo(result);
    }
    static class Solution {
        public long solution(int price, int money, int count) {
            long answer = 0;

            for (int i = 1; i <= count; i++) {
                answer += price * i;
            }

            if (answer <= money) {
                return 0;
            }

            return answer - money;
        }
    }
}
