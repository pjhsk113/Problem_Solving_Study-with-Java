package 프로그래머스;

import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class 두개_뽑아서_더하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] numbers;
        int[] result;

        numbers = new int[] {2,1,3,4,1};
        result = new int[] {2,3,4,5,6,7};

        assertThat(solution.solution(numbers)).isEqualTo(result);

        numbers = new int[] {5,0,2,7};
        result = new int[] {2,5,7,9,12};

        assertThat(solution.solution(numbers)).isEqualTo(result);
    }
    static class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = {};
            int length = numbers.length;
            Set<Integer> set = new TreeSet<>();

            for (int i = 0; i < length; i++) {
                for (int j = i+1; j < length; j++) {
                    set.add(numbers[i] + numbers[j]);
                }
            }
            answer = set.stream().mapToInt(Number::intValue).toArray();
            return answer;
        }
    }
}
