package 프로그래머스.level1;

import static org.assertj.core.api.Assertions.assertThat;

public class 이상한_문자_만들기 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s;
        String result;

        s = "try hello world";
        result = "TrY HeLlO WoRlD";

        assertThat(solution.solution(s)).isEqualTo(result);

        s = "a b c d e";
        result = "A B C D E";

        assertThat(solution.solution(s)).isEqualTo(result);

    }
    static class Solution {
        public String solution(String s) {
            String answer = "";
            String[] arr = s.split("");
            int cnt = 0;

            for (String word : arr) {
                cnt = word.equals(" ") ? 0 : ++cnt;
                answer += cnt % 2 == 0 ? word.toLowerCase() : word.toUpperCase();
            }

            return answer;
        }
    }
}
