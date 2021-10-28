package 프로그래머스.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class 오픈채팅방 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] record;
        String[] result;

        record = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        result = new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};

        assertThat(solution.solution(record)).isEqualTo(result);

    }
    static class Solution {
        private static final String ENTER = "Enter";
        private static final String LEAVE = "Leave";
        private static final String CHANGE = "Change";
        private static final String ENTER_MESSAGE = "%s님이 들어왔습니다.";
        private static final String LEAVE_MESSAGE = "%s님이 나갔습니다.";

        public String[] solution(String[] record) {
            List<String> answer = new ArrayList<>();
            Map<String, String> user = new HashMap<>();

            for (String info : record) {
                String[] userInfo = info.split(" ");
                String status = userInfo[0];
                String userId = userInfo[1];
                String userName = "";

                if (!status.equals(LEAVE)) {
                    userName = userInfo[2];
                } else {
                    continue;
                }

                user.put(userId, userName);
            }

            for (int i = 0; i < record.length; i++) {
                String[] userInfo = record[i].split(" ");
                String status = userInfo[0];
                String userId = userInfo[1];

                if (status.equals(ENTER)) {
                    answer.add(String.format(ENTER_MESSAGE, user.get(userId)));
                }

                if (status.equals(LEAVE)) {
                    answer.add(String.format(LEAVE_MESSAGE, user.get(userId)));
                }
            }

            return answer.stream().toArray(String[]::new);
        }
    }
}
