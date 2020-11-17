package MakeArrayUnique;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeArray_동현 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[];
        int ans;

        arr = new int[]{1, 2, 2};
        ans = 1;
        assertThat(solution.minIncrementForUnique(arr)).isEqualTo(ans);

        arr = new int[]{3, 2, 1, 2, 1, 7};
        ans = 1;
        assertThat(solution.minIncrementForUnique(arr)).isEqualTo(ans);
    }
    static class Solution {
        public int minIncrementForUnique(int[] A) {
            int ans = 0;
            return ans;
        }
    }
}
