package leetcode.studyPlan;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] nums;
        String output;

        nums = new String[]{"flower","flow","flight"};
        output = "fl";
        assertThat(solution.longestCommonPrefix(nums)).isEqualTo(output);

        nums = new String[]{"dog","racecar","car"};
        output = "";
        assertThat(solution.longestCommonPrefix(nums)).isEqualTo(output);
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }

            String prefix = strs[0];

            for (int i = 1; i < strs.length; i++) {
                String currentString = strs[i];

                while(!currentString.startsWith(prefix)) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
            }

            return prefix;
        }
    }
}
