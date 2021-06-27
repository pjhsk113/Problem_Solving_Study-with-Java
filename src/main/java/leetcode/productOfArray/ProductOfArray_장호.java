package leetcode.productOfArray;

import static org.assertj.core.api.Assertions.assertThat;

/* O(n)으로 풀것 */
public class ProductOfArray_장호 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int nums[];
        int ans[];

        nums = new int[]{1, 2, 3, 4};
        ans = new int[]{24, 12, 8, 6};
        assertThat(solution.productExceptSelf(nums)).isEqualTo(ans);
    }

    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int ans[] = new int[nums.length];
            int temp[] = new int[nums.length];
            ans[0] = 1;
            temp[nums.length-1] = 1;

            for (int i = 1; i < nums.length; i++) {
                ans[i] = nums[i-1] * ans[i-1];
            }
            for (int i = nums.length - 1; i > 0; i--) {
                temp[i-1] = nums[i] * temp[i];
                System.out.println(temp[i-1]);
            }
            for (int i = 0; i < nums.length; i++) {
                ans[i] = ans[i] * temp[i];
            }
            return ans;
        }
    }
}
