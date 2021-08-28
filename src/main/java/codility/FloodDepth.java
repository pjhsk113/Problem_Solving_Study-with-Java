package codility;

import static org.assertj.core.api.Assertions.assertThat;

public class FloodDepth {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] A;
        int ans;

        A = new int[] {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
        ans = 2;
        assertThat(solution.solution(A)).isEqualTo(ans);

        A = new int[] {8, 1, 8};
        ans = 7;
        assertThat(solution.solution(A)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int[] A) {
            if (A.length <= 2) {
                return 0;
            }

            int lowestIdx = 0;
            int highestIdx = 0;
            int max = 0;

            for (int i = 1; i < A.length; i++) {
                int current = A[i];
                int highest = A[highestIdx];
                int lowest = A[lowestIdx];

                if (current > highest) {
                    max = Math.max(highest - lowest, max);
                    highestIdx = i;
                    lowestIdx = highestIdx;
                } else if (current > lowest) {
                    max = Math.max(current - lowest, max);
                } else if (current < lowest) {
                    lowestIdx = i;
                }
            }

            return max;
        }
    }
}
