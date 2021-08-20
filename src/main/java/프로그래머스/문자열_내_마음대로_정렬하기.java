package 프로그래머스;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class 문자열_내_마음대로_정렬하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strings;
        int n;
        String[] result;

        strings = new String[]{"sun", "bed", "car"};
        n = 1;
        result = new String[]{"car", "bed", "sun"};

        assertThat(solution.solution(strings, n)).isEqualTo(result);

        strings = new String[]{"abce", "abcd", "cdx"};
        n = 2;
        result = new String[]{"abcd", "abce", "cdx"};

        assertThat(solution.solution(strings, n)).isEqualTo(result);
    }
    static class Solution {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, (o1, o2) -> {
                if (o1.charAt(n) == o2.charAt(n)) {
                    return o1.compareTo(o2);
                }
                return o1.charAt(n) - o2.charAt(n);
            });

            return strings;
        }
    }
}
