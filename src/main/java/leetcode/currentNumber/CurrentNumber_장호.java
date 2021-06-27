package leetcode.currentNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrentNumber_장호 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[];
        int ans[];

        nums = new int[]{8, 1, 2, 2, 3};
        ans = new int[]{4, 0, 1, 1, 3};
        assertThat(solution.smallerNumbersThanCurrent(nums)).isEqualTo(ans);

        nums = new int[]{6, 5, 4, 8};
        ans = new int[]{2, 1, 0, 3};
        assertThat(solution.smallerNumbersThanCurrent(nums)).isEqualTo(ans);

        nums = new int[]{7, 7, 7, 7};
        ans = new int[]{0, 0, 0, 0};
        assertThat(solution.smallerNumbersThanCurrent(nums)).isEqualTo(ans);
    }

    static class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int length = nums.length;
            int ans[] = new int[length];
            int cnt = 0;

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (nums[i] > nums[j]) {
                        ++cnt;
                    }
                }
                ans[i] = cnt;
                cnt = 0;
            }

            return ans;
        }
    }
}
