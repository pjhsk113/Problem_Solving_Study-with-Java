import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class 주식가격_장호 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int prices[];
        int answer[];

        prices = new int[] {1, 2, 3, 2, 3, 3, 1};
        answer = new int[] {6, 5, 1, 3, 2, 1, 0};
        assertThat(solution.solved(prices)).containsExactly(answer);
        assertThat(solution.solved2(prices)).containsExactly(answer);

        prices = new int[] {1, 2, 3, 2, 3, 3};
        answer = new int[] {5, 4, 1, 2, 1, 0};
        assertThat(solution.solved(prices)).containsExactly(answer);
        assertThat(solution.solved2(prices)).containsExactly(answer);

        prices = new int[100000];
        answer = new int[100000];
        for (int i = 0; i < 100000; i++) {
            prices[i] = i + 1;
        }
        for (int i = 0; i < 100000; i++) {
            answer[i] = 99999 - i;
        }
        assertThat(solution.solved(prices)).containsExactly(answer);
        assertThat(solution.solved2(prices)).containsExactly(answer);
    }

    static class Solution {
        public int[] solved(int[] prices) {
            int[] answer = new int[prices.length];

            for (int i = 0; i < prices.length; i++) {
                for (int j = i+1; j < prices.length; j++ ) {
                    if (prices[i] <= prices[j]) {
                        answer[i]++;
                    } else {
                        answer[i]++;
                        break;
                    }
                }
            }
            return answer;
        }

        public int[] solved2(int[] prices) {
            int[] answer = new int[prices.length];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < prices.length; i++) {
                while (!stack.empty() && prices[stack.peek()] > prices[i]) {
                    answer[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
            while (!stack.empty()) {
                answer[stack.peek()] = (prices.length - stack.peek()) - 1;
                stack.pop();
            }
            return answer;
        }
    }
}
