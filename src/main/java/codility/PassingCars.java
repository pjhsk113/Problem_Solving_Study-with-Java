package codility;

import static org.assertj.core.api.Assertions.assertThat;

public class PassingCars {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int ans;

        A = new int[]{0, 1, 0, 1, 1};
        ans = 5;
        assertThat(solution.solution(A)).isEqualTo(ans);
    }

    static class Solution {
        public int solution(int[] A) {
            int cnt = 0;
            int ans = 0;

            for (int a : A) {
                if (a == 0) {
                    cnt++;
                }
                if (a == 1) {
                    ans += cnt;
                }
            }

            if (ans > 1000000000 || ans < 0) {
                return -1;
            }

            return ans;
        }
    }
}
