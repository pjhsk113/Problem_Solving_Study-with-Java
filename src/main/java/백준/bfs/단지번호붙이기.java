package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단지번호붙이기 {
    static int[][] map = new int[25][25];
    static int[][] area = new int[25][25];
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n;
    static int[] ans = new int[25];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        n = Integer.parseInt(input);

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1 && area[i][j] ==0){
                    dfs(i, j, ++count);
                }
            }
        }

        System.out.println(count);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[area[i][j]] += 1;
            }
        }
        Arrays.sort(ans);
        for(int i = 0; i < ans.length - 1; i++) {
            if (ans[i] != 0) {
                System.out.println(ans[i]);
            }
        }
    }

    static void dfs(int x, int y, int count) {
        area[x][y] = count;
        for(int k = 0; k < 4; k++){
            int nx= x + dx[k];
            int ny= y + dy[k];
            if(0<= nx && nx <n && 0<= ny && ny <n){
                if(map[nx][ny] == 1 && area[nx][ny] == 0){
                    dfs(nx, ny, count);
                }
            }
        }
    }
}
