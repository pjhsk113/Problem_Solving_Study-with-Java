package 백준.구현;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 제로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int ans = 0;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if (x == 0) {
                deque.pollLast();
            } else {
                deque.offerLast(x);
            }
        }

        for (int number : deque) {
            ans += number;
        }

        System.out.println(ans);
    }
}
