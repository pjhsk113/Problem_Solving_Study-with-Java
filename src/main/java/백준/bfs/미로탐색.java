package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 미로탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] intput = br.readLine().split(" ");

        int n = Integer.parseInt(intput[0]);
        int m = Integer.parseInt(intput[1]);
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int map[][] = new int[n][m];
        int ans[][] = new int[n][m];
        boolean visited[][] = new boolean[n][m];
        Queue<Node> que = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        que.offer(new Node(0,0,1));
        visited[0][0] = true;

        while(!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        ans[nx][ny] = node.dist;
                        que.offer(new Node(nx, ny, node.dist+1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        System.out.println(ans[n-1][m-1] + 1);
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
