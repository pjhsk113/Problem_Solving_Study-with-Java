package codility;

import static org.assertj.core.api.Assertions.assertThat;

public class MinAvgTwoSlice {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] A;
        int ans;

        A = new int[] {4,2,2,5,1,5,8};
        ans = 1;
        assertThat(solution.solution(A)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int[] A) {
            int answer = 0;
            float firstGroupAvg = 0;
            float secondGroupAvg = 0;
            float minAvg = (A[0] + A[1]) / 2f;

            for (int i = 2; i < A.length; i++) {
                firstGroupAvg = (A[i-1] + A[i]) / 2f;
                secondGroupAvg = (A[i-2] + A[i-1] + A[i]) / 3f;

                if (minAvg > firstGroupAvg) {
                    minAvg = firstGroupAvg;
                    answer = i - 1;
                }

                if (minAvg > secondGroupAvg) {
                    minAvg = secondGroupAvg;
                    answer = i - 2;
                }
            }

            return answer;
        }
    }
}
