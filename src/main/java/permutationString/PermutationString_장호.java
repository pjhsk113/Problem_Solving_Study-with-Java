package permutationString;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationString_장호 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1, s2;
        boolean output;

        s1 = "ab";
        s2 = "eidbaooo";
        output = true;
        assertThat(solution.checkInclusion(s1, s2)).isEqualTo(output);

        s1 = "ab";
        s2 = "eidboaoo";
        output = false;
        assertThat(solution.checkInclusion(s1, s2)).isEqualTo(output);
    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            return false;
        }
    }
}
