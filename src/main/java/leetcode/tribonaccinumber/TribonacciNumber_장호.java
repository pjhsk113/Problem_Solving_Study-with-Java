package leetcode.tribonaccinumber;

import static org.assertj.core.api.Assertions.assertThat;

public class TribonacciNumber_장호 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int input,output;

        input = 4; output = 4;
       assertThat(solution.tribonacci(input)).isEqualTo(output);

        input = 25; output = 1389537;
        assertThat(solution.tribonacci(input)).isEqualTo(output);

        input = 0; output = 0;
        assertThat(solution.tribonacci(input)).isEqualTo(output);
    }

    static class Solution {
        public int tribonacci(int n) {
            if (n == 0) return 0;
            if (n == 1 || n == 2) return 1;

            int[] memo = new int[n+1];

            memo[0] = 0;
            memo[1] = 1;
            memo[2] = 1;
            for (int i = 3; i <= n; i++ ) {
                memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
            }
            return memo[n];
        }
    }
}
