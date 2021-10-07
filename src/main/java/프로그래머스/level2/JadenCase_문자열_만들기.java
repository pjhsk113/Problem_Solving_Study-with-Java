package 프로그래머스.level2;

import static org.assertj.core.api.Assertions.assertThat;

public class JadenCase_문자열_만들기 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s;
        String result;

        s = "3people unFollowed me";
        result = "3people Unfollowed Me";

        assertThat(solution.solution(s)).isEqualTo(result);

        s = "for the last week";
        result = "For The Last Week";

        assertThat(solution.solution(s)).isEqualTo(result);

        s = "f  D  s ";
        result = "F  D  S ";

        assertThat(solution.solution(s)).isEqualTo(result);
    }
    static class Solution {
        public String solution(String s) {
            String answer = "";
            String[] arr = s.split("");
            boolean isBlank = true;

            for (String word : arr) {
                answer += isBlank ? word.toUpperCase() : word.toLowerCase();
                isBlank = word.equals(" ") ? true : false;
            }

            return answer;
        }
    }
}
