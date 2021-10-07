package 프로그래머스.level2;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class 숫자의_표현 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n;
        int result;

        n = 15;
        result = 4;

        assertThat(solution.solution(n)).isEqualTo(result);

    }
    static class Solution {
        public int solution(int n) {
            int answer = 0;
            
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = i; j <= n; j++) {
                    sum += j;

                    if (sum == n) {
                        answer++;
                        break;
                    }

                    if (sum > n) {
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
