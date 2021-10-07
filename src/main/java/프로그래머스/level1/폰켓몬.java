package 프로그래머스.level1;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class 폰켓몬 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums;
        int result;

        nums = new int[]{3, 1, 2, 3};
        result = 2;

        assertThat(solution.solution(nums)).isEqualTo(result);

        nums = new int[]{3,3,3,2,2,4};
        result = 3;

        assertThat(solution.solution(nums)).isEqualTo(result);

        nums = new int[]{3,3,3,2,2,2};
        result = 2;

        assertThat(solution.solution(nums)).isEqualTo(result);
    }
    static class Solution {
        public int solution(int[] nums) {
            Set<Integer> phonekemon = new HashSet<>();

            for (int num : nums) {
                phonekemon.add(num);
            }

            if (phonekemon.size() > (nums.length / 2)) {
                return nums.length / 2;
            }

            return phonekemon.size();
        }
    }
}
