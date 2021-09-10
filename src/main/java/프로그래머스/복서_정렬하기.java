package 프로그래머스;

import java.util.*;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class 복서_정렬하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] weights;
        String[] head2head;
        int[] result;

        weights = new int[]{50,82,75,120};
        head2head = new String[]{"NLWL","WNLL","LWNW","WWLN"};
        result = new int[]{3,4,1,2};

        assertThat(solution.solution(weights, head2head)).isEqualTo(result);

        weights = new int[]{145,92,86};
        head2head = new String[]{"NLW","WNL","LWN"};
        result = new int[]{2,3,1};

        assertThat(solution.solution(weights, head2head)).isEqualTo(result);

        weights = new int[]{60,70,60};
        head2head = new String[]{"NNN","NNN","NNN"};
        result = new int[]{2,1,3};

        assertThat(solution.solution(weights, head2head)).isEqualTo(result);
    }
    static class Solution {
        public int[] solution(int[] weights, String[] head2head) {
            int[] answer = new int[weights.length];
            List<Boxer> boxers = new ArrayList<>();

            for (int i = 0; i < weights.length; i++) {
                int win = 0;
                int weightWin = 0;
                int matchCount = 0;
                for (int j = 0; j < weights.length; j++) {
                    if (head2head[i].charAt(j) != 'N') {
                        matchCount++;
                    }
                    if (head2head[i].charAt(j) == 'W') {
                        win++;
                        if (weights[i] < weights[j]) {
                            weightWin++;
                        }
                    }
                }
                double winRate = 0;
                if (matchCount != 0) {
                    winRate = (double)win / matchCount * 100;
                }


                boxers.add(new Boxer(i + 1, winRate, weightWin, weights[i]));
            }

            Collections.sort(boxers);

            for (int i = 0; i < boxers.size(); i++) {
                answer[i] = boxers.get(i).getBoxerNumber();
            }

            return answer;
        }

        static class Boxer implements Comparable<Boxer> {
            private int boxerNumber;
            private double winCount;
            private int heavierWinCount;
            private int weight;

            public Boxer(int boxerNumber, double winCount, int heavierWinCount, int weight) {
                this.boxerNumber = boxerNumber;
                this.winCount = winCount;
                this.heavierWinCount = heavierWinCount;
                this.weight = weight;
            }

            public int getBoxerNumber() {
                return boxerNumber;
            }


            @Override
            public int compareTo(Boxer o) {
                if (this.winCount == o.winCount) {
                    if (this.heavierWinCount == o.heavierWinCount) {
                        if (this.weight == o.weight) {
                            return this.boxerNumber - o.boxerNumber;
                        }
                        return o.weight - this.weight;
                    }
                    return o.heavierWinCount - this.heavierWinCount;
                }

                return Double.compare(o.winCount, this.winCount);
            }
        }
    }
}
