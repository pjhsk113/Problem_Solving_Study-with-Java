package codility;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxProductOfThree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int ans;

        A = new int[]{-3, 1, 2, -2, 5, 6};
        ans = 60;
        assertThat(solution.solution(A)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int[] A) {
            int length = A.length;
            int positive = 0;
            int negative = 0;
            int ans = 0;
            Arrays.sort(A);

            positive = A[length-3] * A[length-2] * A[length-1];
            negative = A[0] * A[1] * A[length-1];
            if (positive > negative) {
                ans = positive;
            } else {
                ans = negative;
            }

            return ans;
        }
    }
}
