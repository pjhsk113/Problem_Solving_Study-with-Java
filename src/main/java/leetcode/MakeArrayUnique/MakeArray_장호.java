package leetcode.MakeArrayUnique;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeArray_장호 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[];
        int ans;

        arr = new int[]{1, 2, 2};
        ans = 1;
        assertThat(solution.minIncrementForUnique(arr)).isEqualTo(ans);

        arr = new int[]{3, 2, 1, 2, 1, 7};
        ans = 6;

        arr = new int[]{1, 0};
        ans = 0;
        assertThat(solution.minIncrementForUnique(arr)).isEqualTo(ans);
    }
    static class Solution {
        public int minIncrementForUnique(int[] A) {
            if (A.length <= 1) {
                return 0;
            }
            Arrays.sort(A);
            int ans = 0, targetNumber = A[0];
            for (int i = 1; i < A.length; i++) {
                if (targetNumber < A[i]) {
                    targetNumber = A[i];
                }else {
                    ans += (targetNumber - A[i]) + 1;
                    targetNumber++;
                }
            }
            return ans;
        }
    }
}