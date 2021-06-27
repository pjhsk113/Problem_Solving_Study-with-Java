package 프로그래머스.구명보트;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 구명보트_동현 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int people[];
        int limit;
        int ans;

        people = new int[]{70, 50, 80, 50};
        limit = 100;
        ans = 3;
        assertThat(solution.solution(people, limit)).isEqualTo(ans);

        people = new int[]{70, 80, 50};
        limit = 100;
        ans = 3;
        assertThat(solution.solution(people, limit)).isEqualTo(ans);

        people = new int[]{10, 10, 10};
        limit = 100;
        ans = 2;
        assertThat(solution.solution(people, limit)).isEqualTo(ans);

        people = new int[]{40, 40, 80};
        limit = 160;
        ans = 2;
        assertThat(solution.solution(people, limit)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            int f_count = 0;
            int e_count = people.length  - 1;
            Arrays.sort(people);

            while(e_count - f_count >= 1) {
                if (people[f_count] + people[e_count] <= limit) {
                    f_count++;
                    e_count--;
                }
                else
                    e_count--;
                answer++;
            }
            if(e_count == f_count)
                answer++;

            return answer;
        }
    }
}
