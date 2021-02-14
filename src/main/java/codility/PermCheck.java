package codility;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PermCheck {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int ans;

        A = new int[]{4,1,3,2};
        ans = 1;
        assertThat(solution.solution(A)).isEqualTo(ans);

        A = new int[]{4,1,3};
        ans = 0;
        assertThat(solution.solution(A)).isEqualTo(ans);
    }

    static class Solution {
        public int solution(int[] A) {
            int cnt = 0;
            Arrays.sort(A);

            for (int i = 0; i < A.length; i++) {
                if (A[i] == (i + 1)) {
                    cnt++;
                }
            }

            if (cnt == A.length) {
                return 1;
            }

            return 0;
        }
    }
}
