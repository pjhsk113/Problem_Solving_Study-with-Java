package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 연구소 {
    static int n, m;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputRange = br.readLine().split(" ");
        n = Integer.parseInt(inputRange[0]);
        m = Integer.parseInt(inputRange[1]);
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        dfs(0);
        System.out.println(ans);
        br.close();
    }

    static void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCount + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> que = new ArrayDeque<>();
        int[][] virusMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virusMap[i][j] = map[i][j];
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusMap[i][j] == 2) {
                    que.offer(new Node(i, j));
                }
            }
        }

        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (virusMap[nx][ny] == 0) {
                        virusMap[nx][ny] = 2;
                        que.offer(new Node(nx, ny));
                    }
                }
            }
        }
        safeAreaCount(virusMap);
    }

    static void safeAreaCount(int[][] virusMap) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
