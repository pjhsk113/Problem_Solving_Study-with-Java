package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class 입실_퇴실 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] enter;
        int[] leave;
        int[] result;

//        enter = new int[]{1,3,2};
//        leave = new int[]{1,2,3};
//        result = new int[]{0,1,1};
//
//        assertThat(solution.solution(enter, leave)).isEqualTo(result);

        enter = new int[]{1,4,2,3};
        leave = new int[]{2,1,3,4};
        result = new int[]{2,2,1,3};

        assertThat(solution.solution(enter, leave)).isEqualTo(result);

        enter = new int[]{3,2,1};
        leave = new int[]{2,1,3};
        result = new int[]{1,1,2};

        assertThat(solution.solution(enter, leave)).isEqualTo(result);

        enter = new int[]{3,2,1};
        leave = new int[]{1,3,2};
        result = new int[]{2,2,2};

        assertThat(solution.solution(enter, leave)).isEqualTo(result);

        enter = new int[]{1,4,2,3};
        leave = new int[]{2,1,4,3};
        result = new int[]{2,2,0,2};

        assertThat(solution.solution(enter, leave)).isEqualTo(result);

    }

    static class Solution {
        public int[] solution(int[] enter, int[] leave) {
            int[] answer = new int[enter.length+1];
            int[][] meet = new int[enter.length+1][];
            List<Integer> office = new ArrayList<>();
            int enterPointer = 0;
            int leavePointer = 0;
            int length = enter.length;
            while (enterPointer < length || leavePointer < length) {
                if (!office.contains(leave[leavePointer])) {
                    office.add(enter[enterPointer]);
                    meet[leavePointer] = office.stream().mapToInt(i -> i).toArray();
                    enterPointer++;
                } else {
                    office.remove((Integer)leave[leavePointer]);
                    leavePointer++;
                }
            }

            for (int i = 1; i < meet.length; i++) {
                if (meet[i] == null) {
                    continue;
                }
                for (int j =1; j < meet[i].length; j++) {
                    meet[meet[i][j]] = meet[i];
                }
            }
            for (int[] i : meet) {
                if (i == null) {
                    System.out.println(0);
                    continue;
                }
                for (int j : i) {
                    System.out.print(j);
                }
                System.out.println();
            }
            return answer;
        }
    }
}
