package codility;

import static org.assertj.core.api.Assertions.assertThat;

public class CodingTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s;
        int ans;

        s = "aabab";
        ans = 3;
        assertThat(solution.solution(s)).isEqualTo(ans);

        s = "aabaabaa";
        ans = 0;
        assertThat(solution.solution(s)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(String s) {
            int answer = 0;

            if (s.startsWith("aaa") || s.endsWith("aaa")) {
                return -1;
            }

            String ss = s.replaceAll("aa", "");

            String newS = "";
            for (int i = 0 ; i< ss.length(); i++) {
                if (i == 0) {
                    newS += "aa" + ss.charAt(i);
                    continue;
                }

                if (i == ss.length() -1) {
                    newS += ss.charAt(i) + "aa";
                    continue;
                }

                if (ss.charAt(i) == 'a') {
                    newS += "aa";
                    continue;
                } else {
                    newS += "aa" + ss.charAt(i) + "aa";
                }

            }
            System.out.println(newS);
            answer = newS.length() - s.length();
            return answer;
        }
    }
}
