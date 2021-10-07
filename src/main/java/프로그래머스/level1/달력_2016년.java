package 프로그래머스.level1;

import static org.assertj.core.api.Assertions.assertThat;


public class 달력_2016년 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int a;
        int b;
        String result;

        a = 5;
        b = 24;
        result = "TUE";

        assertThat(solution.solution(a, b)).isEqualTo(result);

        a = 1;
        b = 1;
        result = "FRI";

        assertThat(solution.solution(a, b)).isEqualTo(result);

    }
    static class Solution {
        public String solution(int a, int b) {
            String answer = "";
            String[] days = new String[]{"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
            int[] month = new int[] {31,29,31,30,31,30,31,31,30,31,30,31};
            int dayCount = 0;

            for (int i = 0; i < a-1; i++) {
                dayCount += month[i];
            }
            dayCount += b;

            answer = days[dayCount % 7];
            return answer;
        }
    }
}
