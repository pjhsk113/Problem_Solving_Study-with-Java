package 기능개발;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 기능개발_동현 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] progresses;
        int[] speeds;
        int[] ans;

        progresses = new int[]{93, 30, 55};
        speeds = new int[]{1, 30, 5};
        assertThat(solution.solution(progresses, speeds)).isEqualTo(Arrays.asList(2, 1));
        System.out.println("통과");

        progresses = new int[]{95, 90, 99, 99, 80, 99};
        speeds = new int[]{1, 1, 1, 1, 1,1};
        assertThat(solution.solution(progresses, speeds)).isEqualTo(Arrays.asList(1, 3, 2));
        System.out.println("통과");
    }

    static class Solution {
         List<Integer> solution(int[] progresses, int[] speeds) {
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < progresses.length; i++) {
                queue.add(progresses[i]);
            }

            int day = 1;
            int pivot = 0;
            while (!queue.isEmpty()) {
                Integer peek = queue.peek();
                if (peek + speeds[pivot] * day >= 100) {
                    int count = 1;
                    queue.poll();
                    pivot++;
                    while (!queue.isEmpty() && queue.peek() + speeds[pivot] * day >= 100) {
                        queue.poll();
                        pivot++;
                        count++;
                    }
                    ans.add(count);
                }
                day++;
            }


            return ans;
        }
    }
}
