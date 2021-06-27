package leetcode.problem1.perfectsquares;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Perfect_Squares_동현 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int input, ouput;

        input = 12;
        ouput = 3;
        assertThat(solution.numSquares(input)).isEqualTo(ouput);
        //12 = 4 + 4 + 4.

        input = 13;
        ouput = 2;
        assertThat(solution.numSquares(input)).isEqualTo(ouput);
        //13 = 4 + 9.

    }


    static class Solution {
        public int numSquares(int n) {
            int dp[] = new int[n+1];
            Arrays.fill(dp,-1);
            return f(n,dp);
        }

        int f(int n,int[] dp) {
            if(dp[n] != -1) return dp[n];
            if(n == 0) return 0;
            int min = Integer.MAX_VALUE;
            for(int i=1; i * i <= n; i++) {
                int curr = 1+f(n - i*i,dp);
                min = Math.min(min,curr);
            }
            return dp[n] = min;
        }
    }
}
