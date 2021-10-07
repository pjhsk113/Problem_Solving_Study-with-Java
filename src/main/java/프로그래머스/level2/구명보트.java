package 프로그래머스.level2;

import java.util.ArrayDeque;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 구명보트 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int people[];
        int limit;
        int ans;

        people = new int[]{70, 50, 80, 50};
        limit = 100;
        ans = 3;
        assertThat(solution.solution(people,limit)).isEqualTo(ans);

        people = new int[]{70, 80, 50};
        limit = 100;
        ans = 3;
        assertThat(solution.solution(people,limit)).isEqualTo(ans);

        people = new int[]{20, 50, 20, 10, 50, 80};
        limit = 100;
        ans = 3;
        assertThat(solution.solution(people,limit)).isEqualTo(ans);

        people = new int[]{20, 50, 20, 10, 50, 80, 10};
        limit = 100;
        ans = 4;
        assertThat(solution.solution(people,limit)).isEqualTo(ans);
    }

    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            ArrayDeque<Integer> dq = new ArrayDeque<Integer>();

            Arrays.sort(people);

            for (int i = 0; i < people.length; i++) {
                dq.add(people[i]);
            }

            while (!dq.isEmpty()) {
                if (dq.peekFirst() + dq.peekLast() > limit) {
                    dq.pollLast();
                    answer++;
                } else {
                    dq.pollFirst();
                    dq.pollLast();
                    answer++;
                }
            }
            return answer;
        }
    }
}
