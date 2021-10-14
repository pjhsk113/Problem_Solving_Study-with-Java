package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 쉬운_최단거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][m];
        int[][] ans = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                ans[i][j] = -1;
            }
        }

        Queue<Node> que = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    que.offer(new Node(i, j, 1));
                    visited[i][j] = true;
                    ans[i][j] = 0;
                }
            }
        }

        while(!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] != 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        ans[nx][ny] = node.dist;
                        que.offer(new Node(nx, ny, node.dist+1));
                    }

                    if (map[nx][ny] == 0) {
                        ans[nx][ny] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 0) {
                        ans[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

}
//15 15
//2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
//1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 0 0 0 0 0
//1 1 1 1 1 1 1 1 1 1 0 1 1 0 1