package leetcode.studyPlan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s;
        int output;

        s = "III";
        output = 3;
        assertThat(solution.romanToInt(s)).isEqualTo(output);

        s = "LVIII";
        output = 58;
        assertThat(solution.romanToInt(s)).isEqualTo(output);

        s = "MCMXCIV";
        output = 1994;
        assertThat(solution.romanToInt(s)).isEqualTo(output);
    }

    static class Solution {
        public int romanToInt(String s) {
            String[] symbol = new String[]{"I", "V", "X", "L", "C", "D", "M"};
            int[] value = new int[]{1,5,10,50,100,500,1000};
            Map<String, Integer> symbolMap = new HashMap<>();
            for (int i = 0; i < value.length; i++) {
                symbolMap.put(symbol[i], value[i]);
            }

            int answer = 0;
            Queue<Integer> que = new LinkedList<>();
            String[] splitStr = s.split("");

            for (int i = 0; i < splitStr.length; i++) {
                que.offer(symbolMap.get(splitStr[i]));
            }

            while(!que.isEmpty()) {
                int topNumber = que.poll();
                System.out.println(topNumber);

                if (que.peek() == null) {
                    answer += topNumber;
                    return answer;
                }

                if(topNumber < que.peek()) {
                    answer -= topNumber;
                } else {
                    answer += topNumber;
                }
            }

            return answer;
        }
    }
}
