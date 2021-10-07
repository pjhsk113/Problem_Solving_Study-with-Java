package 프로그래머스.level1;

import static org.assertj.core.api.Assertions.assertThat;

public class 삼진법_뒤집기 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n;
        int result;

        n = 45;
        result = 7;

        assertThat(solution.solution(n)).isEqualTo(result);

        n = 125;
        result = 229;

        assertThat(solution.solution(n)).isEqualTo(result);
    }
    static class Solution {
        public int solution(int n) {
            int answer = 0;
            StringBuilder sb = new StringBuilder();

            while(n > 0){
                sb.append(n % 3);
                n /= 3;
            }

            return Integer.parseInt(sb.toString(), 3);
        }
    }
}
