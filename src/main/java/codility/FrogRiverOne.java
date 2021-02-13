package codility;

import static org.assertj.core.api.Assertions.assertThat;

public class FrogRiverOne {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int X;
        int ans;

        A = new int[]{1,3,1,4,2,3,5,4};
        X = 5;
        ans = 6;
        assertThat(solution.solution(X, A)).isEqualTo(ans);

        A = new int[]{2,2,2,2,2};
        X = 2;
        ans = -1;
        assertThat(solution.solution(X, A)).isEqualTo(ans);
    }

    static class Solution {
        public int solution(int X, int[] A) {
            boolean[] visited = new boolean[X];
            int cnt = 0;

            for (int i = 0; i < A.length; i++) {
                if (A[i] <= X) {
                    if (!visited[A[i]-1]) {
                        cnt++;
                    }
                    visited[A[i]-1] = true;
                }

                if (cnt == X) {
                    return i;
                }
            }
            return -1;
        }
    }
}
