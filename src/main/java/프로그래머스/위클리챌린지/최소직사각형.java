package 프로그래머스.위클리챌린지;

import static org.assertj.core.api.Assertions.assertThat;

public class 최소직사각형 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] sizes;
        int result;

        sizes = new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        result = 4000;

        assertThat(solution.solution(sizes)).isEqualTo(result);

        sizes = new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        result = 120;

        assertThat(solution.solution(sizes)).isEqualTo(result);
    }
    static class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;
            int width = 0;
            int height = 0;

            for (int[] size : sizes) {
                width = Math.max(width, Math.max(size[0], size[1]));
                height = Math.max(height, Math.min(size[0], size[1]));
            }

            answer = width * height;
            return answer;
        }
    }
}
