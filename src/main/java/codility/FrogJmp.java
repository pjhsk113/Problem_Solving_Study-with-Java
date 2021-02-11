package codility;

import static org.assertj.core.api.Assertions.assertThat;

public class FrogJmp {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int X;
        int Y;
        int D;
        int ans;

        X = 10;
        Y = 85;
        D = 30;
        ans = 3;

        assertThat(solution.solution(X,  Y, D)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int X, int Y, int D) {
            int ans = 0;

            if (X == Y) {
                return 0;
            }

            ans = ((Y - X) / D);

            if (((Y - X) % D) == 0 ) {
                return ans;
            }

            return ans + 1;
        }
    }
}
