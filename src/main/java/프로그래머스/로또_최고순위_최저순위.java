package 프로그래머스;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class 로또_최고순위_최저순위 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] lottos;
        int[] win_nums;
        int[] result;

        lottos = new int[]{44, 1, 0, 0, 31, 25};
        win_nums = new int[]{31, 10, 45, 1, 6, 19};
        result = new int[]{3, 5};

        assertThat(solution.solution(lottos, win_nums)).isEqualTo(result);

        lottos = new int[]{0, 0, 0, 0, 0, 0};
        win_nums = new int[]{38, 19, 20, 40, 15, 25};
        result = new int[]{1, 6};

        assertThat(solution.solution(lottos, win_nums)).isEqualTo(result);

        lottos = new int[]{45, 4, 35, 20, 3, 9};
        win_nums = new int[]{20, 9, 3, 45, 4, 35};
        result = new int[]{1, 1};

        assertThat(solution.solution(lottos, win_nums)).isEqualTo(result);
    }
    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] rank = {6, 6, 5, 4, 3, 2, 1};

            int zeroCount = (int) Arrays.stream(lottos)
                    .filter(i -> i == 0)
                    .count();


            int winCount = (int) Arrays.stream(lottos)
                    .filter(i -> IntStream.of(win_nums).anyMatch(x -> x == i))
                    .count();

            return new int[]{ rank[zeroCount + winCount], rank[winCount] };
        }
    }
}
