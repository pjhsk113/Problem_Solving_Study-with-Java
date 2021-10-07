package 프로그래머스.level1;

import static org.assertj.core.api.Assertions.assertThat;

public class 약수의_개수와_덧셈 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int left;
        int right;
        int result;

        left = 13;
        right= 17;
        result = 43;

        assertThat(solution.solution(left, right)).isEqualTo(result);

        left = 24;
        right= 27;
        result = 52;

        assertThat(solution.solution(left, right)).isEqualTo(result);
    }
    static class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            int cnt = 0;
            for (int i = left; i <= right; i++) {
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) {
                        cnt++;
                    }

                }

                if (cnt % 2 == 0) {
                    answer += i;
                } else {
                    answer -= i;
                }
                cnt = 0;
            }
            return answer;
        }
    }
}
