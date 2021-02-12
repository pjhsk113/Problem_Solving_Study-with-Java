package codility;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TapeEquilibrium {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int ans;

        A = new int[] {3, 1, 2, 4, 3};
        ans = 1;
        assertThat(solution.solution(A)).isEqualTo(ans);
    }
    static class Solution {
        public int solution(int[] A) {
            int length = A.length;
            int[] aSum = new int[length];
            int[] pSum = new int[length];
            int[] ans = new int[length];
            int sum1 = 0;
            int sum2 = 0;

            for (int i = 0; i < length - 1; i++) {
                sum1 += A[i];
                aSum[i] = sum1;
            }

            for (int i = length - 1 ; i >= 1; i--) {
                sum2 += A[i];
                pSum[i] = sum2;

            }

            for (int i = 0; i < length -1; i++) {
                if (aSum[i] > pSum[i+1]) {
                    ans[i] = aSum[i] - pSum[i+1];
                } else {
                    ans[i] = pSum[i+1] - aSum[i];
                }
            }

            Arrays.sort(ans);

            return ans[1];
        }
    }

}
