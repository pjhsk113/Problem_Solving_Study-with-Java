package ReduceNumberToZero;

import static org.assertj.core.api.Assertions.assertThat;

public class Reduce_장호 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num;
        int ans;

        num = 14;
        ans = 6;
        assertThat(solution.numberOfSteps(num)).isEqualTo(ans);

        num = 4;
        ans = 8;
        assertThat(solution.numberOfSteps(num)).isEqualTo(ans);

        num = 123;
        ans = 12;
        assertThat(solution.numberOfSteps(num)).isEqualTo(ans);
    }

    static class Solution {
        public int numberOfSteps (int num) {
            int ans = 0;

            return ans;
        }
    }
}
