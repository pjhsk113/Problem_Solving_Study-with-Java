package 프로그래머스;

import static org.assertj.core.api.Assertions.assertThat;

public class N개의_최소공배수 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr;
        int result;

        arr = new int[]{2,6,8,14};
        result = 168;

        assertThat(solution.solution(arr)).isEqualTo(result);

        arr = new int[]{1,2,3};
        result = 6;

        assertThat(solution.solution(arr)).isEqualTo(result);
    }
    static class Solution {
        public int solution(int[] arr) {
            int answer = lcmN(arr);

            return answer;
        }

        private int lcmN(int[] arr) {
            int tempLcm = arr[0];
            for (int i = 1; i < arr.length; i++) {
                tempLcm = lcm(tempLcm, arr[i]);
            }

            return tempLcm;
        }

        private int gcd(int a, int b) {
            while(b!=0) {
                int r = a % b;
                a = b;
                b = r;
            }

            return a;
        }

        private int lcm(int a, int b) {
            return a * b / gcd(a, b);

        }
    }
}
