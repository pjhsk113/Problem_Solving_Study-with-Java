package 프로그래머스;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class KaKaoCodingTest2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n;
        int k;
        int ans;

        n = 437674;
        k = 3;
        ans = 3;
        assertThat(solution.solution(n, k)).isEqualTo(ans);

        n = 110011;
        k = 10;
        ans = 2;
        assertThat(solution.solution(n, k)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int n, int k) {
            int answer = 0;
            String[] temp = conversion(n, k).split("[0]+");
            for (String number: temp) {
                if (isPrime(Integer.parseInt(number))) {
                    answer++;
                }
            }

            return answer;
        }

        static String conversion(int number, int N){
            StringBuilder sb = new StringBuilder();
            int current = number;

            while(current > 0){
                if(current % N < 10){
                    sb.append(current % N);
                } else {
                    sb.append((char)(current % N - 10 + 'A'));
                }
                current /= N;
            }

            return sb.reverse().toString();
        }

        static boolean isPrime(long num) {
            if (num <= 1) {
                return false;
            }
            for(long i=2; i*i<=num; i++){
                if(num % i == 0) return false;
            }
            return true;
        }
    }
}
