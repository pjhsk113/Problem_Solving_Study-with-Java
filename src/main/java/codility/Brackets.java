package codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Brackets {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String S;
        int ans;

        S = "{[()()]}";
        ans = 1;
        assertThat(solution.solution(S)).isEqualTo(ans);

        S = "([)()]";
        ans = 0;
        assertThat(solution.solution(S)).isEqualTo(ans);
    }

    static class Solution {
        public int solution(String S) {
            Stack<Character> stack = new Stack<>();
            Map<Character,Character> map = new HashMap<>();
            int ans = 0;

            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');

            for (char s : S.toCharArray()) {
                if (!stack.empty()){
                    if (stack.peek().equals(map.get(s))) {
                        stack.pop();
                    } else {
                        stack.push(s);
                    }
                } else {
                    stack.push(s);
                }
            }

            if (stack.empty()) {
                ans = 1;
            }

            return ans;
        }
    }
}
