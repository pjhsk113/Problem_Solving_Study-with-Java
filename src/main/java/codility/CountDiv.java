package codility;

import static org.assertj.core.api.Assertions.assertThat;

public class CountDiv {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int A;
        int B;
        int K;
        int ans;

        A = 6;
        B = 11;
        K = 2;
        ans = 3;
        assertThat(solution.solution(A, B, K)).isEqualTo(ans);

        A = 3;
        B = 19;
        K = 3;
        ans = 6;
        assertThat(solution.solution(A, B, K)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int A, int B, int K) {
            int startValue = A / K;
            int lastValue = B / K;
            int ans = 0;

            if (A % K == 0) {
                ans = lastValue - startValue  + 1;
            } else {
                ans = lastValue - startValue;
            }

            return ans;
        }
    }
}
