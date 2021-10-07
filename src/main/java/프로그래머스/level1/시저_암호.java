package 프로그래머스.level1;

import static org.assertj.core.api.Assertions.assertThat;


public class 시저_암호 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s;
        int n;
        String result;

        s ="AB";
        n = 1;
        result = "BC";

        assertThat(solution.solution(s, n)).isEqualTo(result);

        s = "z";
        n = 1;
        result = "a";

        assertThat(solution.solution(s, n)).isEqualTo(result);

        s = "a B z";
        n = 4;
        result = "e F d";

        assertThat(solution.solution(s, n)).isEqualTo(result);
    }
    static class Solution {
        public String solution(String s, int n) {
            String answer = "";
            char x;
            char start;
            for (int i = 0; i < s.length(); i++) {
                x = s.charAt(i);

                if (x != ' ') {
                    start = Character.isLowerCase(x) ? 'a' : 'A';
                    x = (char)(start + (x + n - start)% 26);
                }
                answer += x;
            }
            return answer;
        }
    }
}
