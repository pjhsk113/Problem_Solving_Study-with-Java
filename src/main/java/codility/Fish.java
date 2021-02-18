package codility;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Fish {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int[] B;
        int ans;

        A = new int[]{4,3,2,1,5};
        B = new int[]{0,1,0,0,0};
        ans = 2;
        assertThat(solution.solution(A, B)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int[] A, int[] B) {
            Stack<Integer> stack = new Stack<>();
            int cnt = 0;

            for (int i = 0; i < A.length; i++) {
                if (B[i] == 1) {
                    stack.push(A[i]);
                } else {
                    while (!stack.empty()) {
                        if(stack.peek() < A[i]) {
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                    if (stack.empty()) {
                        cnt++;
                    }
                }

            }

            return cnt + stack.size();
        }
    }
}
