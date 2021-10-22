package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int h = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        int[] map = new int[500];

        int maxIndex = 0;
        int maxValue = 0;

        String[] block = br.readLine().split(" ");
        for (int i = 0; i < w; i++) {
            map[i] = Integer.parseInt(block[i]);
            if (maxValue < map[i]) {
                maxIndex = i;
                maxValue = map[i];
            }
        }

        int ans = 0;
        int leftMax = map[0];
        for (int i = 1; i < maxIndex; i++) {
            if (leftMax > map[i]) {
                ans += leftMax - map[i];
            } else {
                leftMax = map[i];
            }
        }

        int rightMax = map[w-1];
        for (int i = w-2; i >= maxIndex; i--) {
            if (rightMax > map[i]) {
                ans += rightMax - map[i];
            } else {
                rightMax = map[i];
            }
        }

        System.out.println(ans);
    }
}
