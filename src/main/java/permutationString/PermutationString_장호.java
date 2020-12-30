package permutationString;

import java.util.ArrayList;
import java.util.List;

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

        s1 = "adc";
        s2 = "dcda";
        output = true;
        assertThat(solution.checkInclusion(s1, s2)).isEqualTo(output);
    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 =  s1.length();
            int len2 =  s2.length();
            List<String> permutations;

            if (len1 > len2) {
                return false;
            }

            permutations =  permutation("", s1);
            for (String s : permutations) {
                for (int i = len1; i <= len2; i++) {
                    String compareStr = s2.substring(i - len1, i);
                    if (s.equals(compareStr)) {
                        return true;
                    }
                }
            }

            return false;
        }
        private List<String> permutation(String prefix,String str) {
            List<String> permutations = new ArrayList<>();
            int len = str.length();
            if (len == 0) {
                permutations.add(prefix);
            } else {
                for (int i = 0; i < len; i++) {
                    permutations.addAll(permutation(prefix + str.charAt(i),
                            str.substring(0, i) + str.substring(i + 1, len)));
                }
            }
            return permutations;
        }
    }
}
