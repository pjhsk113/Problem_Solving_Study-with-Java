package codility;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Distinct {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int ans;

        A = new int[]{2, 1, 1, 2, 3, 1};
        ans = 3;
        assertThat(solution.solution(A)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int[] A) {
            Set<Integer> set = new HashSet<>();

            for (int a : A) {
                set.add(a);
            }

            return set.size();
        }
    }
}
