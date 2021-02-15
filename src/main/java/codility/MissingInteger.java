package codility;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class MissingInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int ans;

        A = new int[]{1, 3, 6, 4, 1, 2};
        ans = 5;
        assertThat(solution.solution(A)).isEqualTo(ans);

        A = new int[]{1, 2, 3};
        ans = 4;
        assertThat(solution.solution(A)).isEqualTo(ans);

        A = new int[]{-1, -3};
        ans = 1;
        assertThat(solution.solution(A)).isEqualTo(ans);
    }

    static class Solution {
        public int solution(int[] A) {
            Set<Integer> set = new HashSet<>();
            int ans = 0;

            for (int a : A) {
                set.add(a);
            }

            for (int i = 1; i <= 1000000; i++) {
                if (!set.contains(i)) {
                    ans = i;
                    break;
                }
            }

            return ans;
        }
    }
}
