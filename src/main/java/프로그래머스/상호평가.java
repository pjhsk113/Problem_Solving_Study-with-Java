package 프로그래머스;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 상호평가 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] numbers;
        String result;

        numbers = new int[][] {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        result = "FBABD";

        assertThat(solution.solution(numbers)).isEqualTo(result);

        numbers = new int[][] {{50,90},{50,87}};
        result = "DA";

        assertThat(solution.solution(numbers)).isEqualTo(result);

        numbers = new int[][] {{70,49,90},{68,50,38},{73,31,100}};
        result = "CFD";

        assertThat(solution.solution(numbers)).isEqualTo(result);
    }
    static class Solution {
        public String solution(int[][] scores) {
            StringBuilder answer = new StringBuilder();
            int studentCount = scores.length;
            List<List<Integer>> scoreList = new ArrayList<>();


            for (int i = 0; i < studentCount; i++) {
                List<Integer> score = new ArrayList<>();

                for (int j = 0; j < studentCount; j++) {
                    score.add(scores[j][i]);
                }

                scoreList.add(score);
            }
            int i = 0;
            for (List<Integer> score : scoreList) {
                Integer myScore = score.get(i);
                i++;

                OptionalDouble od = isUniqueMaxValue(score, myScore);
                answer.append(getGrade(od.getAsDouble()));

            }

            return answer.toString();
        }


        private OptionalDouble isUniqueMaxValue(List<Integer> score, Integer myScore) {
            int maxValue = score.stream().max(Comparator.comparing(x -> x)).get();
            int minValue = score.stream().min(Comparator.comparing(x -> x)).get();

            if (maxValue == myScore) {
                if (!isDupulicateScore(score, myScore)) {
                    score.remove(myScore);
                }
            }

            if (minValue == myScore) {
                if (!isDupulicateScore(score, myScore)) {
                    score.remove(myScore);
                }
            }

            return score.stream()
                    .mapToDouble(i -> i)
                    .average();
        }

        private boolean isDupulicateScore(List<Integer> score, int myScore) {
            int cnt = (int) score.stream()
                    .filter(i -> i == myScore)
                    .count();

            if (cnt > 1) {
                return true;
            }

            return false;
        }

        private String getGrade(double score) {
            String grade = "A";

            if (score >= 90) {
                grade = "A";
            } else if (score >= 80) {
                grade = "B";
            } else if (score >= 70) {
                grade = "C";
            } else if (score >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

            return grade;
        }
    }
}
