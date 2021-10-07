package 프로그래머스.level2;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class N진수_게임 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n;
        int t;
        int m;
        int p;
        String ans;

        n = 2;
        t = 4;
        m = 2;
        p = 1;
        ans = "0111";
        assertThat(solution.solution(n,t,m,p)).isEqualTo(ans);

        n = 16;
        t = 16;
        m = 2;
        p = 1;
        ans = "02468ACE11111111";
        assertThat(solution.solution(n,t,m,p)).isEqualTo(ans);

        n = 16;
        t = 16;
        m = 2;
        p = 2;
        ans = "13579BDF01234567";
        assertThat(solution.solution(n,t,m,p)).isEqualTo(ans);

    }

    static class Solution {
        public String solution(int n, int t, int m, int p) {
            String answer = "";
            String temp = "0";
            int cnt = 0;
            int total = p-1;

            while(answer.length() < t) {
                temp += conversion(cnt, n);

                if (temp.length() > total) {
                    answer += temp.charAt(total);
                    total += m;
                }
                cnt++;
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

    }
}
