package 프로그래머스.level2;

import 백준.bfs.미로탐색;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 컬러링북 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n, m;
        int[][] picture;
        int[] result;

        n = 6;
        m = 4;
        picture = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        result = new int[]{4, 5};

        assertThat(solution.solution(n,m,picture)).isEqualTo(result);

    }
    static class Solution {
        static int[] dx = {0, 1, 0, -1};
        static int[] dy = {-1, 0, 1, 0};
        static int area, count, maxCount;

        public int[] solution(int m, int n, int[][] picture) {
            area = 0;
            count = 0;
            maxCount = 0;

            int[] answer = new int[2];
            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (picture[i][j] != 0 && !visited[i][j]) {
                        area++;
                        dfs(i, j, picture, visited);
                    }

                    if (count > maxCount) {
                        maxCount = count;
                    }
                    count = 0;
                }
            }
            answer[0] = area;
            answer[1] = maxCount;
            return answer;
        }

        static void dfs(int x, int y, int[][] picture, boolean[][] visited) {
            if (visited[x][y]) {
                return;
            }

            visited[x][y] = true;
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < picture.length && ny < picture[0].length) {
                    if (!visited[nx][ny] && picture[x][y] == picture[nx][ny]) {
                        dfs(nx, ny, picture, visited);
                    }
                }
            }
        }
    }
}
