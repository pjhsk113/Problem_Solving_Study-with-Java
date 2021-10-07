package 프로그래머스.level1;

import static org.assertj.core.api.Assertions.assertThat;

public class 신규_아이디_추천 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String new_id;
        String result;

        new_id = "...!@BaT#*..y.abcdefghijklm";
        result = "bat.y.abcdefghi";

        assertThat(solution.solution(new_id)).isEqualTo(result);

        new_id = "z-+.^.";
        result = "z--";

        assertThat(solution.solution(new_id)).isEqualTo(result);

        new_id = "=.=";
        result = "aaa";

        assertThat(solution.solution(new_id)).isEqualTo(result);

        new_id = "123_.def";
        result = "123_.def";

        assertThat(solution.solution(new_id)).isEqualTo(result);

        new_id = "abcdefghijklmn.p";
        result = "abcdefghijklmn";

        assertThat(solution.solution(new_id)).isEqualTo(result);
    }
    static class Solution {
        public String solution(String new_id) {
            String answer = getNewId(new_id);
            return answer;
        }

        private String getNewId(String id) {
            String new_id = "";

            new_id = replaceLowerCase(id);
            new_id = removeSpecialCharacter(new_id);
            new_id = replaceFullStop(new_id);
            new_id = removeStartOrEndFullStop(new_id);
            new_id = whenEmptySubstitute(new_id);
            new_id = whenLengthOver(new_id);
            new_id = whenLengthLower(new_id);

            return new_id;
        }

        private String replaceLowerCase(String id) {
            return id.toLowerCase();
        }

        private String removeSpecialCharacter(String id) {
            return id.replaceAll("[^0-9|a-z|_.-]", "");
        }

        private String replaceFullStop(String id) {
            return id.replaceAll("[.]{2,}", ".");
        }

        private String removeStartOrEndFullStop(String id) {
            if (id.startsWith(".")) {
                id = id.replaceFirst(".", "");
            }

            if (id.endsWith(".")) {
                id = id.substring(0, id.length()-1);
            }

            return id;
        }

        private String whenEmptySubstitute(String id) {
            if (id.isEmpty()) {
                id = id + "a";
            }

            return id;
        }

        private String whenLengthOver(String id) {
            if (id.length() >= 16) {
                id = id.substring(0, 15);
            }

            if (id.endsWith(".")) {
                id = id.substring(0, id.length() -1);
            }

            return id;
        }

        private String whenLengthLower(String id) {
            String lastWord = "";
            if (id.length() <= 2) {
                lastWord = id.substring(id.length()-1);
            }

            while (id.length() < 3) {
                id = id + lastWord;
            }

            return id;
        }
    }
}
