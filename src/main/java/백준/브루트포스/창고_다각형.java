package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 창고_다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][2];
        int[] wareHouse = new int[1001];
        int ans = 0;
        int maxHeight = 0;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            map[i][0] = Integer.parseInt(input[0]);
            map[i][1] = Integer.parseInt(input[1]);

            wareHouse[map[i][0]] = map[i][1];
            if (maxHeight < map[i][1]) {
                maxIndex = map[i][0];
                maxHeight = map[i][1];
            }
        }

        Arrays.sort(map, Comparator.comparingInt(o -> o[0]));

        int maxLeft = 0;
        for (int i = 0; i < maxIndex; i++) {
            maxLeft = Math.max(maxLeft, wareHouse[i]);
            ans += maxLeft;
        }

        int maxRight = 0;
        int lastIndex = map[n-1][0];

        for (int i = lastIndex; i >= maxIndex; i--) {
            maxRight = Math.max(maxRight, wareHouse[i]);
            ans += maxRight;
        }

        System.out.println(ans);
        br.close();
    }
}
