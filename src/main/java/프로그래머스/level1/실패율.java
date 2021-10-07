package 프로그래머스.level1;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 실패율 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int N;
        int[] stages;
        int[] result;

        N = 5;
        stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        result = new int[]{3,4,2,1,5};

        assertThat(solution.solution(N, stages)).isEqualTo(result);

        N = 4;
        stages = new int[]{4,4,4,4,4};
        result = new int[]{4,1,2,3};

        assertThat(solution.solution(N, stages)).isEqualTo(result);
    }
    static class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            int user = stages.length;

            Map<Integer, Float> map = new HashMap<>();

            for (int i = 1; i <= N; i++) {
                int cnt = 0;
                float fail = 0;
                for (int userStage : stages) {
                    if (userStage == i) {
                        cnt++;
                    }
                }

                if (user <= 0) {
                    fail = 0;
                } else {
                    fail = (float) cnt / user;
                }

                map.put(i, fail);
                user = user - cnt;

            }

            List<Map.Entry<Integer, Float>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            for (int i = 0; i < N; i++) {
                answer[i] = list.get(i).getKey();
            }

            return answer;
        }
    }
}
