package 기능개발;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 기능개발_장호 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] progresses;
        int[] speeds;
        int[] answer;

        progresses = new int[] {93, 30, 55};
        speeds = new int[] {1, 30, 5};
        answer = new int[] {2, 1};

        assertThat(solution.solved(progresses, speeds)).containsExactly(answer);

        progresses = new int[] {95, 90, 99, 99, 80, 99};
        speeds = new int[] {1, 1, 1, 1, 1,1};
        answer = new int[] {1, 3, 2};
        assertThat(solution.solved(progresses, speeds)).containsExactly(answer);

        progresses = new int[] {99, 1, 99, 1};
        speeds = new int[] {1, 1, 1, 1};
        answer = new int[] {1, 3};
        assertThat(solution.solved(progresses, speeds)).containsExactly(answer);

        progresses = new int[] {0, 0, 0, 0};
        speeds = new int[] {100, 50, 34, 25};
        answer = new int[] {1, 1, 1, 1};
        assertThat(solution.solved(progresses, speeds)).containsExactly(answer);

        progresses = new int[] {5, 5, 5};
        speeds = new int[] {21, 25, 20};
        answer = new int[] {3};
        assertThat(solution.solved(progresses, speeds)).containsExactly(answer);

    }

    /**
     * 배포 가능 일자를 구하고, 배포되는 기능의 갯수를 그룹핑해 품
     */
    static class Solution {
        public int[] solved(int[] progresses, int[] speeds) {
            int max = 0;
            List<Integer> complete = new ArrayList<Integer>();
            List<int[]> result = new ArrayList<int[]>();

            // 배포가능 일자를 구함
            for (int i = 0; i < progresses.length; i++) {
                complete.add((int) Math.ceil((double)(100 - progresses[i]) / speeds[i]));

                // 현재 값이 이전 최대 값보다 커지면 새로운 그룹을 생성
                if (complete.get(i) > max) {
                    max = complete.get(i);
                    result.add(new int[]{ 1 });
                // 새로운 그룹이 만들어지기 전까지 해당 그룹의 count를 증가시켜줌
                } else {
                    result.get(result.size() - 1)[0]++;
                }
            }

            int[] answer = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i)[0];
            }

            return answer;
        }
    }
}
