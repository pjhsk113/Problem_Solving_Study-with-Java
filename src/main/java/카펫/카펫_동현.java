package 카펫;

import static org.assertj.core.api.Assertions.assertThat;

public class 카펫_동현 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int brown;
        int yellow;
        int[] answer;

        brown = 10;
        yellow = 2;
        answer = new int[] {4, 3};

        assertThat(solution.solution(brown, yellow)).containsExactly(answer);

        brown = 8;
        yellow = 1;
        answer = new int[] {3, 3};

        assertThat(solution.solution(brown, yellow)).containsExactly(answer);

        brown = 24;
        yellow = 24;
        answer = new int[] {8, 6};

        assertThat(solution.solution(brown, yellow)).containsExactly(answer);


    }

    static class Solution {
        public int[] solution(int brown, int yellow) {
            int height = 0;
            int width = 0;
            for (height = 3; height <= (int) (brown + 4) / 2; height++) {

                width = ((brown + 4) / 2) - height;
                if (width < height) {
                    break;
                }

                int yellowCount = (width - 2) * (height - 2);
                if (yellow == yellowCount) {
                    break;
                }
            }


            return new int[] { width, height };
        }
    }
}
