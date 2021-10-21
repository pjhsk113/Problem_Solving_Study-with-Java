package 백준.구현;

import java.math.BigInteger;
import java.util.Scanner;

public class 큰수AB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger A = new BigInteger(sc.next());
        BigInteger B = new BigInteger(sc.next());

        System.out.println(A.add(B));
    }
}
