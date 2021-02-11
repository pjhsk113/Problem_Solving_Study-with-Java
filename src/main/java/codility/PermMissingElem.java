package codility;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PermMissingElem {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int ans;

        A = new int[]{2, 3, 1, 5};
        ans = 4;
        assertThat(solution.solution(A)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int[] A) {
            Arrays.sort(A);

            if (A.length == 0) {
                return 1;
            }

            for(int i = 0; i < A.length; i++) {
                if (A[i] != (i + 1)) {
                    return i + 1;
                }
            }

            return A.length + 1;
        }
    }
}
