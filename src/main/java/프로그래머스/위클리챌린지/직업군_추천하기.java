package 프로그래머스.위클리챌린지;

import java.security.KeyStore;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class 직업군_추천하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] table = new String[] {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};;
        String[] languages;
        int[] preference;
        String result;

        languages = new String[] {"PYTHON", "C++", "SQL"};
        preference = new int[] {7,5,5};
        result = "HARDWARE";

        assertThat(solution.solution(table, languages, preference)).isEqualTo(result);

        languages = new String[] {"JAVA", "JAVASCRIPT"};
        preference = new int[] {7,5};
        result = "PORTAL";

        assertThat(solution.solution(table, languages, preference)).isEqualTo(result);

        languages = new String[] {"JAVA"};
        preference = new int[] {7};
        result = "PORTAL";

        assertThat(solution.solution(table, languages, preference)).isEqualTo(result);
    }
    static class Solution {
        public String solution(String[] table, String[] languages, int[] preference) {
            String answer = "";
            String[][] splitTable = new String[5][6];
            Map<String, Integer> score = new HashMap<>();

            for (int i = 0; i < table.length; i++) {
                splitTable[i] = table[i].split(" ");
            }

            for (int i = 0; i < splitTable.length; i++) {
                int sum = 0;
                for (int j = 0; j < languages.length; j++) {
                    for (int k = 0; k < splitTable[i].length; k++) {
                        if (languages[j].equals(splitTable[i][k])) {
                            sum += (6 - k) * preference[j];
                            break;
                        }
                    }
                }
                score.put(splitTable[i][0], sum);
            }

            List<Map.Entry<String,Integer>> keySetList = new ArrayList<>(score.entrySet());

            Collections.sort(keySetList, (o1, o2) -> {
                if (o2.getValue().compareTo(o1.getValue()) == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            });

            answer = keySetList.get(0).getKey();

            return answer;
        }
    }
}
