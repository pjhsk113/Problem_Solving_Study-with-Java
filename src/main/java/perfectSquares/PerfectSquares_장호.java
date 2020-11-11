package perfectSquares;

import static org.assertj.core.api.Assertions.assertThat;

public class PerfectSquares_장호 {
    public static void main(String[] args) {
        PerfectSquares_동현.Solution solution = new PerfectSquares_동현.Solution();
        int input, ouput;

        input = 12;
        ouput = 3;
        assertThat(solution.numSquares(input)).isEqualTo(ouput);

        input = 13;
        ouput = 2;
        assertThat(solution.numSquares(input)).isEqualTo(ouput);

    }


    static class Solution {
        public int numSquares(int n) {
            int answer = 0;

            return answer;
        }

    }
}
