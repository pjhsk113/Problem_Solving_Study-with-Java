package leetcode.problem1;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Mdh {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] participant = null;
        String[] completion = null;
        String ans = null;

        participant = new String[]{"leo", "kiki", "eden"};
        completion = new String[]{"eden", "kiki"};
        ans = "leo";
        assertThat(solution.solution(participant, completion)).isEqualTo(ans);

        participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        ans = "vinko";
        assertThat(solution.solution(participant, completion)).isEqualTo(ans);

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        ans = "mislav";
        assertThat(solution.solution(participant, completion)).isEqualTo(ans);



        System.out.println("성공");
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            Arrays.sort(participant);
            Arrays.sort(completion);
            for (int i = 0; i < completion.length; i++) {
                if (!participant[i].equals(completion[i])) {
                    return participant[i];
                }
            }
            return participant[participant.length - 1];
        }
    }
}
