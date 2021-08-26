package 프로그래머스;

import static org.assertj.core.api.Assertions.assertThat;


public class 다음_큰_숫자 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n;
        int result;

        n = 78;
        result = 83;

        assertThat(solution.solution(n)).isEqualTo(result);

        n = 15;
        result = 23;

        assertThat(solution.solution(n)).isEqualTo(result);

    }
    static class Solution {
        public int solution(int n) {
            int answer = 0;
            String defaultBinary = Integer.toBinaryString(n);
            int oneCount = getOneCount(defaultBinary);

            int temp = n;

            while(true) {
                ++temp;
                String binary = Integer.toBinaryString(temp);
                int cnt = getOneCount(binary);

                if (oneCount == cnt) {
                    answer = Integer.parseInt(binary, 2);
                    break;
                }
            }
            return answer;
        }

        private int getOneCount(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }

            return count;
        }
    }
}
