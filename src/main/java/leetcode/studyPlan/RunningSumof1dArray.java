package leetcode.studyPlan;

import static org.assertj.core.api.Assertions.assertThat;

public class RunningSumof1dArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        int[] output;

        nums = new int[]{1,2,3,4};
        output = new int[]{1,3,6,10};
        assertThat(solution.runningSum(nums)).containsExactly(output);

        nums = new int[]{1,1,1,1,1};
        output = new int[]{1,2,3,4,5};
        assertThat(solution.runningSum(nums)).containsExactly(output);

        nums = new int[]{3,1,2,10,1};
        output = new int[]{3,4,6,16,17};
        assertThat(solution.runningSum(nums)).containsExactly(output);
    }

    static class Solution {
        public int[] runningSum(int[] nums) {
            int length = nums.length;
            int[] answer = new int[length];
            answer[0] = nums[0];

            for (int i = 1; i < length; i++) {
                answer[i] = nums[i] + answer[i-1];
            }

            return answer;
        }
    }
}
