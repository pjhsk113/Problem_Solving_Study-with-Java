package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 안전_영역 {
    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int map[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        int ans = 1;
        for (int k = min; k <= max; k++) {
            int cnt = 0;
            visited = new boolean[n+1][n+1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > k && !visited[i][j]) {
                        visited[i][j] = true;
                        cnt++;
                        dfs(i, j, k);
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }

    public static void dfs(int x, int y, int height) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(ny < 0 || ny >= n || nx < 0 || ny >= n){
                continue;
            }
            if(map[nx][ny] <= height || visited[nx][ny]){
                continue;
            }
            visited[nx][ny] = true;
            dfs(nx,ny,height);
        }
    }
}
