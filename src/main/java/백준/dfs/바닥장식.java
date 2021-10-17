package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바닥장식 {
    static int n, m;
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = temp[j];
            }
        }

        dfs(0,0, 1);

        br.close();
    }

    static void dfs(int x, int y, int cnt) {
        String tile = map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny]) {
                    if (!tile.equals(map[nx][ny])) {
                        cnt++;
                    }
                    visited[nx][ny] = true;
                    dfs(nx, ny, cnt);
                }
            }
        }
    }
}
