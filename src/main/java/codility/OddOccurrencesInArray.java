package codility;

import static org.assertj.core.api.Assertions.assertThat;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int ans;

        A = new int[] {9, 3, 9, 3, 9, 7, 9};
        ans = 7;
        assertThat(solution.solution(A)).isEqualTo(ans);

        A = new int[] {3, 3, 3, 3, 9, 9, 7};
        ans = 7;
        assertThat(solution.solution(A)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int[] A) {
            int answer = 0;

            for (int a : A) {
                answer = answer ^ a;
            }

            return answer;
        }
    }
}
