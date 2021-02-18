package codility;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Nesting {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String S;
        int ans;

        S = "(()(())())";
        ans = 1;
        assertThat(solution.solution(S)).isEqualTo(ans);

        S = "())";
        ans = 0;
        assertThat(solution.solution(S)).isEqualTo(ans);
    }

    static class Solution {
        public int solution(String S) {
            int ans = 1;
            Stack<Character> stack = new Stack<>();

            for (char s : S.toCharArray()) {
                if (!stack.empty()) {
                    if (stack.peek().equals('(') && s == ')') {
                        stack.pop();
                    }else {
                        stack.push(s);
                    }
                } else {
                    stack.push(s);
                }
            }

            if (stack.size() > 0) {
                ans = 0;
            }
            return ans;
        }
    }
}
