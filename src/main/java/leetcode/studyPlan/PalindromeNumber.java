package leetcode.studyPlan;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int x;
        boolean output;

        x = 121;
        output = true;
        assertThat(solution.isPalindrome(x)).isEqualTo(output);

        x = -121;
        output = false;
        assertThat(solution.isPalindrome(x)).isEqualTo(output);

        x = 10;
        output = false;
        assertThat(solution.isPalindrome(x)).isEqualTo(output);
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            String xToStr = String.valueOf(x);
            String startStr;
            String endStr;
            int pivotIndex = xToStr.length() / 2;

            if (xToStr.length() % 2 == 0) {
                startStr = xToStr.substring(0, pivotIndex);
            } else {
                startStr = xToStr.substring(0, pivotIndex+1);
            }
            endStr = xToStr.substring(pivotIndex);

            StringBuilder sb = new StringBuilder(endStr);

            if (startStr.equals(sb.reverse().toString())) {
                return true;
            }
            return false;
        }
    }
}
