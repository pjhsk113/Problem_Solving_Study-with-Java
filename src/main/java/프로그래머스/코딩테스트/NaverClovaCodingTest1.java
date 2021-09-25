package 프로그래머스.코딩테스트;

import java.util.Arrays;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class NaverClovaCodingTest1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] A;
        boolean ans;

        A = new int[]{1,1,2,2};
        ans = true;
        assertThat(solution.solution(A)).isEqualTo(ans);

        A = new int[]{1,1,1};
        ans = false;
        assertThat(solution.solution(A)).isEqualTo(ans);

    }

    static class Solution {
        public boolean solution(int[] A) {
            Stack<Integer> stack = new Stack<>();

            if (A.length % 2 == 1) {
                return false;
            }

            Arrays.sort(A);

            for (Integer element : A) {
                if (stack.isEmpty()) {
                    stack.push(element);
                } else {
                    if (stack.peek() == element) {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty()) {
                return true;
            }

            return false;
        }
    }
}
