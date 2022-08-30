package leetcode.studyPlan;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FindPivotIndex {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        int output;

        nums = new int[]{1,7,3,6,5,6};
        output = 3;
        assertThat(solution.pivotIndex(nums)).isEqualTo(output);

        nums = new int[]{1,2,3};
        output = -1;
        assertThat(solution.pivotIndex(nums)).isEqualTo(output);

        nums = new int[]{2,1,-1};
        output = 0;
        assertThat(solution.pivotIndex(nums)).isEqualTo(output);
    }

    static class Solution {
        public int pivotIndex(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            int pivot = 0;
            int sliceSum = 0;

            for (int i = 0; i < nums.length; i++) {
                sum -= nums[i];
                pivot = i;

                if (sum == sliceSum) {
                    return pivot;
                }

                sliceSum += nums[i];
            }

            return -1;
        }
    }
}
