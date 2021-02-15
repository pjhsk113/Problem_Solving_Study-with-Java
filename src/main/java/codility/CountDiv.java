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
            int max = 0;
            int min = 0;
            int ans = 0;

            max = (B / K) * K;
            min = (A / K) * K;

            if (A % K == 0) {
                ans = (max / K) - (min / K) + 1;
            } else {
                ans = (max / K) - (min / K);
            }

            return ans;
        }
    }
}
