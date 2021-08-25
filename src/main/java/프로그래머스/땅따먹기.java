package 프로그래머스;

import static org.assertj.core.api.Assertions.assertThat;

public class 땅따먹기 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] land;
        int result;

        land = new int[][] {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        result = 16;

        assertThat(solution.solution(land)).isEqualTo(result);

    }
    static class Solution {
        int solution(int[][] land) {
            int answer = 0;
            int N = land.length -1;

            for (int i = 0; i < N; i++) {

                land[i+1][0] += Math.max(land[i][1], Math.max(land[i][2], land[i][3]));
                land[i+1][1] += Math.max(land[i][0], Math.max(land[i][2], land[i][3]));
                land[i+1][2] += Math.max(land[i][0], Math.max(land[i][1], land[i][3]));
                land[i+1][3] += Math.max(land[i][0], Math.max(land[i][1], land[i][2]));
            }

            answer = Math.max(Math.max(land[N][0], land[N][1]), Math.max(land[N][2], land[N][3]));

            return answer;
        }
    }
}
