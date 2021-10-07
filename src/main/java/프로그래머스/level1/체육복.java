package 프로그래머스.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class 체육복 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n;
        int[] lost;
        int[] reserve;
        int result;

        n = 5;
        lost = new int[]{2, 4};
        reserve = new int[]{1,3,5};
        result = 5;

        assertThat(solution.solution(n, lost, reserve)).isEqualTo(result);

        n = 5;
        lost = new int[]{2, 3, 4};
        reserve = new int[]{3,5};
        result = 4;

        assertThat(solution.solution(n, lost, reserve)).isEqualTo(result);

    }
    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            int cnt = 0;
            Arrays.sort(lost);
            Arrays.sort(reserve);

            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    if (lost[i] == reserve[j]) {
                        lost[i] = -1;
                        reserve[j] = -1;
                        break;
                    }
                }
            }

            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    if (lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1) {
                        lost[i] = -1;
                        reserve[j] = -1;
                    }
                }
            }


            for (int i = 0; i < lost.length; i++) {
                if (lost[i] != -1) {
                    cnt++;
                }
            }
            answer = n - cnt;
            return answer;
        }
    }
}
