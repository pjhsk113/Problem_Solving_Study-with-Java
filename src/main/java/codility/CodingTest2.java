package codility;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CodingTest2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] A;
        int ans;

        A = new int[] {5,19,8,1};
        ans = 7;
        assertThat(solution.solution(A)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int[] A) {
            int answer = 0;
            float targetPollution = Arrays.stream(A).sum() / 2f;
            float pollutionTotal = Arrays.stream(A).sum();
            int lastIdx = A.length -1;

            while (targetPollution < pollutionTotal) {
                Arrays.sort(A);
                A[lastIdx] = A[lastIdx] / 2;
                pollutionTotal = Arrays.stream(A).sum();
                answer++;
            }

            return answer;
        }
    }
}
