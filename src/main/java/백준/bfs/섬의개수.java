package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 섬의개수 {
    static int w, h;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1, 1, -1, -1, 1};
    static int[] dy = {-1, 0, 1, 0, 1, -1, 1, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);

            if (w == 0 && h == 0) {
                break;
            }

            int ans = 0;
            map = new int[h+1][w+1];
            visited = new boolean[h+1][w+1];

            for (int i = 0; i < h; i++) {
                String[] temp = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        ans++;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(ans);
        }

        br.close();
    }

    static void bfs(int x, int y) {
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(x, y));

        while(!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 8; i++) {
                int nh = node.h + dx[i];
                int nw = node.w + dy[i];

                if (nh >= 0 && nw >= 0 && nh < h && nw < w) {
                    if (!visited[nh][nw] && map[nh][nw] == 1) {
                        que.offer(new Node(nh, nw));
                        visited[nh][nw] = true;
                    }
                }
            }
        }
    }

    static class Node {
        int h;
        int w;

        public Node(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}
