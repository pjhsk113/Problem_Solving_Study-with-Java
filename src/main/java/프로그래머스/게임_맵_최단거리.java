package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class 게임_맵_최단거리 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] maps;
        int result;

        maps = new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        result = 11;

        assertThat(solution.solution(maps)).isEqualTo(result);

    }
    static class Solution {
        static final int[] dx = {1,-1,0,0};
        static final int[] dy = {0,0,1,-1};

        public int solution(int[][] maps) {
            int answer;
            int x, y, nx, ny;
            int n = maps.length;
            int m = maps[0].length;

            boolean[][] visited = new boolean[n][m];
            Queue<Integer> que = new LinkedList<>();



            que.offer(0);
            que.offer(0);
            visited[0][0] = true;

            while(!que.isEmpty()) {
                x = que.poll();
                y = que.poll();

                for (int i = 0; i < 4; i++) {
                    nx = x + dx[i];
                    ny = y + dy[i];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }

                    if(maps[nx][ny] == 0) {
                        continue;
                    }

                    if(!visited[nx][ny]){
                        que.offer(nx);
                        que.offer(ny);
                        maps[nx][ny] = maps[x][y] + 1;
                        visited[nx][ny] = true;
                    }
                }
            }

            if(maps[n-1][m-1] ==1) {
                return -1;
            }

            answer = maps[n-1][m-1];

            return answer;
        }
    }
}
