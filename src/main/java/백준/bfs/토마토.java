package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 토마토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] intput = br.readLine().split(" ");

        int n = Integer.parseInt(intput[1]);
        int m = Integer.parseInt(intput[0]);
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int map[][] = new int[n][m];
        int ans = 0;
        boolean visited[][] = new boolean[n][m];
        Queue<Node> que = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                if (map[i][j] == 1) {
                    que.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            Node node = que.poll();
            ans = node.date;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        visited[nx][ny] = true;
                        que.offer(new Node(nx, ny, node.date+1));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    ans = -1;
                }
            }
        }

        System.out.println(ans);
    }

    static class Node {
        int x;
        int y;
        int date;

        public Node(int x, int y, int date) {
            this.x = x;
            this.y = y;
            this.date = date;
        }
    }
}
