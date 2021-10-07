package 프로그래머스.level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class 올바른_괄호 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s;
        boolean result;

        s = "()()";
        result = true;
        assertThat(solution.solution(s)).isEqualTo(result);

        s = "(())()";
        result = true;
        assertThat(solution.solution(s)).isEqualTo(result);

        s =")()(";
        result = false;
        assertThat(solution.solution(s)).isEqualTo(result);

        s ="(()(";
        result = false;
        assertThat(solution.solution(s)).isEqualTo(result);

    }
    static class Solution {
        boolean solution(String s) {
            boolean answer = false;

            Deque<Character> dq = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {
                if (dq.isEmpty()) {
                    dq.push(s.charAt(i));
                    continue;
                }

                if (dq.peek().equals('(') && s.charAt(i) == ')') {
                    dq.pop();
                } else {
                    dq.push(s.charAt(i));
                }

            }

            if (dq.isEmpty()) {
                return true;
            }

            return answer;
        }
    }
}
