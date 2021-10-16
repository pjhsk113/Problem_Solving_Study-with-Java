package 프로그래머스.코딩테스트;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class DevMatching01 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] list;
        String newId;
        String result;

        list = new String[]{"card", "ace13", "ace16", "banker", "ace17", "ace14"};
        newId = "ace";
        result = "ace";
        assertThat(solution.solution(list, newId)).isEqualTo(result);

    }

    static class Solution {
        public String solution(String[] registered_list, String new_id) {
            Map<String,String> idList = new HashMap<>();

            for (String id : registered_list) {
                String N = id.replaceAll("[^0-9]", "");
                idList.put(id, N);
            }

            if (isCorrectNewId(new_id)) {
                if (!idList.containsKey(new_id)) {
                    return new_id;
                }
            }

            String suggestionId = new_id;

            String S = suggestionId.replaceAll("[^a-z]", "");
            String N = suggestionId.replaceAll("[^0-9]", "");

            if (N.isEmpty()) {
                N = "0";
            }
            while (idList.containsKey(suggestionId)) {
                String N1 = increaseN(N);
                suggestionId = S + N1;
            }

            return suggestionId;
        }

        public String increaseN(String N) {
            int N1 = Integer.parseInt(N) + 1;
            return String.valueOf(N1);
        }

        public boolean isCorrectNewId(String newId) {
            String S = newId.replaceAll("[^a-zA-Z]", "");
            String N = newId.replaceAll("[^0-9]", "");

            for (int i = 0; i < S.length(); i++) {
                if (Character.isUpperCase(S.charAt(i))) {
                    return false;
                }
            }

            if (S.length() < 3 || S.length() > 6) {
                return false;
            }

            if (N.length() > 6) {
                return false;
            }

            if (newId.startsWith(N)) {
                return false;
            }

            if (N.startsWith("0")) {
                return false;
            }

            return true;
        }
    }
}
