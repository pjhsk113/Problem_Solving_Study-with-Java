package 백준.브루트포스;

import java.util.Scanner;

public class 한수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int ans = 0;

        if (input < 100) {
            System.out.println(input);
            System.exit(0);
        }
        ans = 99;
        for (int i = 100; i <= input; i++) {
            int first = i / 100;
            int second = (i % 100) / 10;
            int third = (i %100) % 10;

            if ((first - second) == (second - third)) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
