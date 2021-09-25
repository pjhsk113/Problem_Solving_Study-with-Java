package 프로그래머스.코딩테스트;

import static org.assertj.core.api.Assertions.assertThat;

public class KaKaoCodingTest6 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] board;
        int[][] skill;
        int ans;

        board = new int[][]{{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        skill = new int[][]{{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        ans = 10;
        assertThat(solution.solution(board, skill)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int[][] board, int[][] skill) {
            int answer = 0;
            for (int i = 0; i < skill.length; i++) {
                int type = skill[i][0];
                int start = skill[i][1];
                int secondStart = skill[i][2];
                int firstRange = skill[i][3];
                int secondRange = skill[i][4];
                int degree = skill[i][5];
                board = getBoards(type, start, secondStart, degree, firstRange, secondRange, board);
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] > 0) {
                        answer++;
                    }
                }
                System.out.println();
            }
            return answer;
        }

        static int[][] getBoards(int type, int start, int secondStart, int degree, int firstRange, int secondRange, int[][] board) {
            for (int i = start; i <= firstRange; i++) {
                for (int j = secondStart; j <= secondRange; j++) {
                    if (type == 1) {
                        board[i][j] -= degree;
                    } else {
                        board[i][j] += degree;
                    }
                }
            }

            return board;
        }
    }

}
