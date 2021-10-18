package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳 {
    static int r, c;
    static int ans = 0;
    static char[][] map;
    static boolean[] visited = new boolean[26];
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        dfs(0, 0, 1);
        System.out.println(ans);
    }

    static void dfs(int x, int y, int cnt) {
        visited[map[x][y] - 'A'] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if (!visited[map[nx][ny] - 'A']) {
                    dfs(nx, ny,cnt + 1);
                }
            }
        }

        visited[map[x][y] - 'A'] = false;
        ans = Math.max(ans, cnt);
    }

}
