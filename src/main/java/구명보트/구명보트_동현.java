package 구명보트;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        assertThat(solution.solution(people,limit)).isEqualTo(ans);

        people = new int[]{70, 80, 50};
        limit = 100;
        ans = 3;
        assertThat(solution.solution(people,limit)).isEqualTo(ans);
    }

    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            List<Integer> list = Arrays.stream(people)
                    .boxed()
                    .collect(Collectors.toList());
            Collections.sort(list);

            while(list.isEmpty()) {
                while()
                answer++;
            }
            return answer;
        }
    }
}
