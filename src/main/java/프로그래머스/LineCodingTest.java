package 프로그래머스;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.map;

public class LineCodingTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] research;
        int n;
        int k;
        String ans;

        research = new String[]{"abaaaa","aaa","abaaaaaa","fzfffffffa"};
        n = 2;
        k = 2;
        ans = "a";
        assertThat(solution.solution(research, n, k)).isEqualTo(ans);

        research = new String[]{"yxxy","xxyyy"};
        n = 2;
        k = 1;
        ans = "x";
        assertThat(solution.solution(research, n, k)).isEqualTo(ans);

        research = new String[]{"yxxy","xxyyy","yz"};
        n = 2;
        k = 1;
        ans = "y";
        assertThat(solution.solution(research, n, k)).isEqualTo(ans);

        research = new String[]{"xy","xy"};
        n = 1;
        k = 1;
        ans = "None";
        assertThat(solution.solution(research, n, k)).isEqualTo(ans);

    }

    static class Solution {
        public String solution(String[] research, int n, int k) {
            String answer = "";
            List<Map<Character, Integer>> researchList = new ArrayList<>();
            List<Map<Character, Integer>> ddd = new ArrayList<>();
            int totalSearch = 2 * n * k;

            for (int i = 0; i < research.length; i++) {
                Map<Character, Integer> searchWord = new HashMap<>();
                for (int j = 0; j < research[i].length(); j++) {
                    if (searchWord.containsKey(research[i].charAt(j))) {
                        Integer point = searchWord.get(research[i].charAt(j)) + 1;
                        searchWord.put(research[i].charAt(j), point);
                    } else {
                        searchWord.put(research[i].charAt(j), 1);
                    }

                }
                researchList.add(searchWord);
            }
            Map<Character, Integer> temp = new TreeMap<>();
            int init = 0;
            for (Map<Character, Integer> researchInfo : researchList) {
                Set<Map.Entry<Character, Integer>> entries = researchInfo.entrySet();

                for (Map.Entry<Character, Integer> entry : entries) {
                    int cnt = 0;
                    int value = 0;
                    boolean flag;
                    for (int i = init; i < researchList.size(); i++) {
                        flag = true;
                        if (researchList.get(i).containsKey(entry.getKey())) {
                            if (flag && entry.getValue() >= k) {
                                cnt++;
                                value += entry.getValue();
                            }

                            if ((cnt == n) && value >= totalSearch) {
                                if (temp.containsKey(entry.getKey())) {
                                    temp.put(entry.getKey(), temp.get(entry.getKey())+1);
                                } else {
                                    temp.put(entry.getKey(), 1);
                                }

                                cnt = 0;
                                value = 0;
                            }

                        } else {
                            cnt = 0;
                            flag = false;
                        }

                    }
                }
                init++;
            }

            List<Character> keyList = new ArrayList<>(temp.keySet());
            Collections.sort(keyList, (o1, o2) ->
                    temp.get(o2).compareTo(temp.get(o1)));

            answer = keyList.get(0).toString();

            return answer;
        }
    }
}
