package codility;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestPassword {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String S;
        int ans;

        S = "test 5 a0A pass007 ?xy1";
        ans = 7;
        assertThat(solution.solution(S)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(String S) {
            int answer = -1;
            String[] word = S.split(" ");

            for (String s : word) {
                if (isValidPassword(s)) {
                    if (answer < s.length() ) {
                        answer = s.length();
                    }
                }
            }

            return answer;
        }

        boolean isValidPassword(String s) {
            if (!s.matches("^[a-zA-Z0-9]*$")) {
                return false;
            }

            int alphaCnt = 0;
            int digitCnt = 0;

            for (int i = 0; i < s.length(); i++) {

                if (Character.isDigit(s.charAt(i))) {
                    digitCnt++;
                } else {
                    alphaCnt++;
                }
            }

            if (digitCnt % 2 == 1 && alphaCnt % 2 == 0) {
                return true;
            }

            return false;
        }
    }
}
