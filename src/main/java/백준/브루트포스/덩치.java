package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] weight = new int[n];
        int[] tall = new int[n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            weight[i] = Integer.parseInt(temp[0]);
            tall[i] = Integer.parseInt(temp[1]);
        }

        for (int i = 0; i < n; i++) {
            int ans = 1;
            for (int j = 0; j < n; j++) {
                if (weight[i] < weight[j] && tall[i] < tall[j]) {
                    ans++;
                }
            }
            System.out.print(ans + " ");
        }

        br.close();

    }
}
