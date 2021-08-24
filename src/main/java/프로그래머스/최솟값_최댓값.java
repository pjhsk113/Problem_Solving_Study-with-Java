package 프로그래머스;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 최솟값_최댓값 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s;
        String result;
//
//        s = "1 2 3 4";
//        result = "1 4";
//
//        assertThat(solution.solution(s)).isEqualTo(result);

        s = "1 3 -4 8 6 9 -5";
        result = "-5 9";

        assertThat(solution.solution(s)).isEqualTo(result);
    }
    static class Solution {
        public String solution(String s) {
            String answer = "";
            String[] ss = s.split(" ");
            int max = 0;
            int min = 0;

            int[] spliter = Arrays.stream(ss).mapToInt(Integer::parseInt).toArray();

            max = Arrays.stream(spliter).max().getAsInt();
            min = Arrays.stream(spliter).min().getAsInt();

            answer = min + " " + max;

            return answer;
        }
    }
}
