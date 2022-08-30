package leetcode.studyPlan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s, t;
        boolean output;

        s = "egg";
        t ="add";
        output = true;
        assertThat(solution.isIsomorphic(s, t)).isEqualTo(output);

        s = "foo";
        t ="bar";
        output = false;
        assertThat(solution.isIsomorphic(s, t)).isEqualTo(output);

        s = "paper";
        t ="title";
        output = true;
        assertThat(solution.isIsomorphic(s, t)).isEqualTo(output);
    }

    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> mappedS = new HashMap<>();
            Set<Character> mappedT = new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                char charS = s.charAt(i);
                char charT = t.charAt(i);

                if (mappedS.containsKey(charS)) {
                    if (mappedS.get(charS) != charT) {
                        return false;
                    }

                } else {
                    if (mappedS.containsValue(charT)) {
                        return false;
                    }

                    mappedS.put(charS, charT);
                }
            }

            return true;
        }
    }
}
