package perfectSquares;

import static org.assertj.core.api.Assertions.assertThat;

public class PerfectSquares_장호 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int input, ouput;

        input = 12;
        ouput = 3;
        assertThat(solution.numSquares(input)).isEqualTo(ouput);

        input = 13;
        ouput = 2;
        assertThat(solution.numSquares(input)).isEqualTo(ouput);

    }


    static class Solution {
        public int numSquares(int n) {
            int[] memo = new int[n+1];
            memo[0] = 0;

            // 1 ^ 2 초기화
            for (int i = 1; i<= n; i++) {
                memo[i] = memo[i-1] +1;
            }

            int cur = 2;
            // n보다 작은 제곱수까지가 계산 범위
            while (cur * cur <= n) {
                // 제곱수는 1로 만듬
                memo[cur*cur] = 1;
                for (int i = cur * cur +1; i <= n; i++) {
                    memo[i] = Math.min(memo[i], memo[i-cur*cur] +1);
                }
                cur++;
            }

            return memo[n];
        }

    }
}
