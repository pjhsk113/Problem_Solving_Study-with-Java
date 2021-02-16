package codility;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Triangle {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int ans;

        A = new int[]{10, 2, 5, 1, 8, 20};
        ans = 1;
        assertThat(solution.solution(A)).isEqualTo(ans);

        A = new int[]{10, 50, 5, 1};
        ans = 0;
        assertThat(solution.solution(A)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int[] A) {
            Arrays.sort(A);
            for (int i = 2; i < A.length; i++) {
                if (A[i] -  A[i-2] < A[i-1]) {
                    return 1;
                }
            }
            return 0;
        }
    }
}
