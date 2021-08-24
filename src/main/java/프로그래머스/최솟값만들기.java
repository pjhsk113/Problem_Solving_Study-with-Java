package 프로그래머스;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class 최솟값만들기 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] A;
        int[] B;
        int result;

        A = new int[] {1, 4, 2};
        B = new int[] {5, 4, 4};
        result = 29;

        assertThat(solution.solution(A, B)).isEqualTo(result);

        A = new int[] {1, 2};
        B = new int[] {3, 4};
        result = 29;

        assertThat(solution.solution(A, B)).isEqualTo(result);
    }
    static class Solution {
        public int solution(int []A, int []B) {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);

            String s = "1 2 3 4";
            String[] ss = s.split(" ");
            Arrays.stream(Arrays.stream(ss).mapToInt(Integer::parseInt).toArray()).sorted();

            for (int i = 0; i < A.length; i++) {
                answer += A[i] * B[(B.length-1) - i];
            }

            return answer;
        }
    }
}
