package leetcode.studyPlan;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        int target;
        int[] output;

        nums = new int[]{2,7,11,15};
        target = 9;
        output = new int[]{0,1};
        assertThat(solution.twoSum(nums, target)).contains(output);

        nums = new int[]{3,2,4};
        target = 6;
        output = new int[]{1,2};
        assertThat(solution.twoSum(nums, target)).contains(output);

        nums = new int[]{3,3};
        target = 6;
        output = new int[]{0,1};
        assertThat(solution.twoSum(nums, target)).contains(output);
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] answer = new int[2];
            Map<Integer, Integer> index = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int sub = target - nums[i];

                if (index.containsKey(sub)) {
                    answer[0] = i;
                    answer[1] = index.get(sub);
                    return answer;
                }
                index.put(nums[i], i);
            }
            return answer;
        }
    }
}
