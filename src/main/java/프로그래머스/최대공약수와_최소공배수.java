package 프로그래머스;

import static org.assertj.core.api.Assertions.assertThat;

public class 최대공약수와_최소공배수 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int left;
        int right;
        int[] result;

        left = 3;
        right= 12;
        result = new int[]{3, 12};

        assertThat(solution.solution(left, right)).isEqualTo(result);

        left = 2;
        right= 5;
        result = new int[]{1, 10};

        assertThat(solution.solution(left, right)).isEqualTo(result);
    }
    static class Solution {
        public int[] solution(int n, int m) {
            int[] answer = new int[2];
            answer[0] = gcd(n, m);
            answer[1] = n * m / gcd(n,m);
            return answer;
        }

        private int gcd(int n, int m) {
            if (n < m) {
                int temp = 0;
                temp = n;
                n = m;
                m = temp;
            }

            while(true) {
                int r = n % m;

                if(r==0) {
                    return m;
                }

                n = m;
                m = r;
            }
        }
    }
}
