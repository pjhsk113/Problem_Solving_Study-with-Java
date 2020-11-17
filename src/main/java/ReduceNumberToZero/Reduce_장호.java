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

        num = 8;
        ans = 4;
        assertThat(solution.numberOfSteps(num)).isEqualTo(ans);

        num = 123;
        ans = 12;
        assertThat(solution.numberOfSteps(num)).isEqualTo(ans);
    }

    static class Solution {
        public int numberOfSteps (int num) {
            int ans = 0;
            while (num > 0) {
                num = num % 2 == 0 ? num / 2 : num - 1;
                ans++;
            }
            return ans;
        }
    }
}
