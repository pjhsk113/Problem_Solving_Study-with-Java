package 프로그래머스;

import static org.assertj.core.api.Assertions.assertThat;

public class 모음사전 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String word;
        int ans;

        word = "AAAAE";
        ans = 6;
        assertThat(solution.solution(word)).isEqualTo(ans);

        word = "AAAE";
        ans = 10;
        assertThat(solution.solution(word)).isEqualTo(ans);

        word = "I";
        ans = 1563;
        assertThat(solution.solution(word)).isEqualTo(ans);

        word = "EIO";
        ans = 1189;
        assertThat(solution.solution(word)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(String word) {
            int answer = 0;
            int distance = 781;

            char[] alpha = new char[]{'A', 'E', 'I', 'O', 'U'};
            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < 5; j++) {
                    if (alpha[j] == word.charAt(i)) {
                        answer += (distance * j) + 1;
                    }
                }
                distance = (distance -1) / 5;
            }

            return answer;
        }
    }
}
