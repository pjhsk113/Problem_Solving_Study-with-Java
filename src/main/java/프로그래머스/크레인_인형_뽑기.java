package 프로그래머스;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;


public class 크레인_인형_뽑기 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] board;
        int[] moves;
        int result;

        board = new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        moves = new int[]{1,5,3,5,1,2,1,4};
        result = 4;
        assertThat(solution.solution(board, moves)).isEqualTo(result);

    }
    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();

            for (int index : moves) {
                for (int i = 0; i < board.length; i++) {
                    if (board[i][index-1] != 0) {
                        if (!stack.isEmpty() && stack.peek() == board[i][index-1]) {
                            stack.pop();
                            answer += 2;
                            board[i][index-1] = 0;
                            break;
                        }

                        stack.push(board[i][index-1]);
                        board[i][index-1] = 0;

                        break;
                    }
                }
            }

            return answer;
        }
    }
}
