package leetcode.studyPlan;

import static org.assertj.core.api.Assertions.assertThat;

public class IsSubsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s, t;
        boolean output;

        s = "abc";
        t ="ahbgdc";
        output = true;
        assertThat(solution.isSubsequence(s, t)).isEqualTo(output);

        s = "axc";
        t ="ahbgdc";
        output = false;
        assertThat(solution.isSubsequence(s, t)).isEqualTo(output);
    }

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            int pointer = 0;

            if (s.isEmpty()) {
                return true;
            }

            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(pointer) == t.charAt(i)) {
                    pointer++;
                    if (pointer == s.length()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
