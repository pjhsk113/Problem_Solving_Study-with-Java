package 백준.브루트포스;

import java.util.Scanner;

public class 분해합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = 0;

        for (int i = 1; i <= 1000000; i++) {
            if (n == decomposition(i)) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }

    static int decomposition(int n) {
        int sum = n;

        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }

        return sum;
    }
}
