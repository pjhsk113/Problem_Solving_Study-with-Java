package codility;

import static org.assertj.core.api.Assertions.assertThat;

public class CyclicRotation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int K;
        int[] ans;

        A = new int[]{3, 8, 9, 7, 6};
        K = 3;
        ans = new int[]{9, 7, 6, 3, 8};
        assertThat(solution.solution(A, K)).containsExactly(ans);

        A = new int[]{0, 0, 0};
        K = 1;
        ans = new int[]{0, 0, 0};
        assertThat(solution.solution(A, K)).containsExactly(ans);

        A = new int[]{1, 2, 3, 4};
        K = 4;
        ans = new int[]{1, 2, 3, 4};
        assertThat(solution.solution(A, K)).containsExactly(ans);
    }

    static class Solution {
        public int[] solution(int[] A, int K) {
            int length = A.length;
            int k = K;
            int[] answer = new int[length];

            if (length < 1) {
                return answer;
            }

            if (k > length) {
                k = k % length;
            }

            if (k % length == 0) {
                return A;
            }

            for (int i = 0; i < length; i++) {
                int idx = i + k;

                if (idx >= length) {
                    idx = idx - length;
                }

                answer[idx] = A[i];
            }

            return answer;
        }
    }
}
