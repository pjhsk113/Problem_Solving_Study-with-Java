package codility;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxCounters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int N;
        int[] ans;

        A = new int[]{3,4,4,6,1,4,4};
        N = 5;
        ans = new int[]{3,2,2,4,2};
        assertThat(solution.solution(N, A)).isEqualTo(ans);

    }

    static class Solution {
        public int[] solution(int N, int[] A) {
            int[] answer = new int[N];
            int currentMax = 0;
            int lastMax = 0;

            for (int a : A) {
                if (a > N) {
                    lastMax = currentMax;
                    continue;
                }

                if (answer[a - 1] < lastMax) {
                    answer[a - 1] = lastMax + 1;
                } else {
                    ++answer[a - 1];
                }

                if (currentMax < answer[a - 1]) {
                    currentMax = answer[a - 1];
                }
            }

            for (int i = 0; i < N; i++) {
                if (answer[i] < lastMax) {
                    answer[i] = lastMax;
                }
            }

            return answer;
        }
    }
}
