package 백준.브루트포스;

public class 셀프넘버 {
    public static void main(String[] args) {
        boolean[] constructor = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            int selfNumber = selfNumber(i);
            if (selfNumber <= 10000) {
                constructor[selfNumber] = true;
            }

        }

        for (int i = 1; i <= 10000; i++) {
            if (!constructor[i]) {
                System.out.println(i);
            }
        }
    }

    static int selfNumber(int n) {
        int sum = n;

        while(n != 0) {
            sum += n % 10;
            n = n / 10;
        }

        return sum;
    }
}
