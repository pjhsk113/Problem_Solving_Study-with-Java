package 백준.브루트포스;

import java.util.Scanner;

public class 영화감독_숌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        int ans = 666;

        while(n != cnt) {
            if (String.valueOf(ans).contains("666")) {
                cnt++;
            }
            ans++;
        }

        System.out.println(ans-1);
    }
}
