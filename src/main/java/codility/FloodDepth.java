package codility;

import static org.assertj.core.api.Assertions.assertThat;

public class FloodDepth {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] A;
        int ans;

        A = new int[] {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
        ans = 2;
        assertThat(solution.solution(A)).isEqualTo(ans);

        A = new int[] {8, 1, 8};
        ans = 7;
        assertThat(solution.solution(A)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int[] A) {
            int answer = 0;
            if (A.length <= 2) {
                return 0;
            }

            int start = A[0];
            int end = A[0];
            int min = Integer.MAX_VALUE;
            int cnt = 0;

            for (int i = 1; i < A.length; i++) {
                if(A[i-1] < A[i]) {
                    if (start <= A[i]) {
                        if (cnt > 0) {
                            answer = Math.max(answer, start - min);
                        }
                        start = A[i];
                    } else {
                        cnt++;
                        if (cnt > 0) {
                            answer = Math.max(answer, start - min);
                        }
//                        min = Math.min(min, A[i]);
                    }

                } else {
                    cnt++;
                    min = Math.min(min, A[i]);
                    end = A[i];
                }
            }

            return answer;
        }
    }
}
