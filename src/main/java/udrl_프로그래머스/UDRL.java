package udrl_프로그래머스;

import static org.assertj.core.api.Assertions.assertThat;

public class UDRL {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String dirs;
        int ans;

        dirs = "ULURRDLLU";
        ans = 7;
        assertThat(solution.solution(dirs)).isEqualTo(ans);

        dirs = "LULLLLLLU";
        ans = 7;
        assertThat(solution.solution(dirs)).isEqualTo(ans);
    }
    static class Solution {
        public int solution(String dirs) {
            int x=5, y=5;
            boolean visited[][] = new boolean[10][10];
            String dir[] = dirs.split("");
            int answer = 1;

            for (String s : dir) {
                if (s.equals("U")) {
                    if (isValid(x, y)) {
                        visited[x][y + 1] = true;
                        y += 1;
                    }
                }
                if (s.equals("D")) {
                    if (isValid(x, y)) {
                        visited[x][y - 1] = true;
                        y -= 1;
                    }
                }
                if (s.equals("R")) {
                    if (isValid(x, y)) {
                        visited[x + 1][y] = true;
                        x += 1;
                    }
                }
                if (s.equals("L")) {
                    if (isValid(x, y)) {
                        visited[x -1][y] = true;
                        x -= 1;
                    }
                }
            }

            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited.length; j++) {
                    if (visited[i][j]) {
                        answer++;
                    }
                }
            }
            return answer;
        }
        private boolean isValid(int x, int y) {
            return x > 0 && x < 10 && y > 0 && y < 10;
        }
    }
}
