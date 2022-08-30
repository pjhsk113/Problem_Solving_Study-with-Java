package leetcode.studyPlan;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s;
        boolean output;

        s = "()";
        output = true;
        assertThat(solution.isValid(s)).isEqualTo(output);

        s = "()[]{}";
        output = true;
        assertThat(solution.isValid(s)).isEqualTo(output);

        s = "(]";
        output = false;
        assertThat(solution.isValid(s)).isEqualTo(output);
    }

    static class Solution {
        public boolean isValid(String s) {
            Deque<String> dq = new ArrayDeque<>();
            Map<String, String> freind = new HashMap<>();
            freind.put("(", ")");
            freind.put("[", "]");
            freind.put("{", "}");

            String[] split = s.split("");
            dq.offer(split[0]);

            for (int i = 1; i < split.length; i++) {
                if (freind.containsKey(split[i])) {
                    dq.offer(split[i]);
                    continue;
                }

                if (dq.peekLast() == null) {
                    dq.offer(split[i]);
                    continue;
                }

                String top = dq.peekLast();

                if (freind.get(dq.peekLast()) == null) {
                    return false;
                }

                if (freind.get(top).equals(split[i])) {
                    dq.pollLast();
                } else {
                    return false;
                }

            }

            if (dq.isEmpty()) {
                return true;
            }

            return false;
        }
    }
}
