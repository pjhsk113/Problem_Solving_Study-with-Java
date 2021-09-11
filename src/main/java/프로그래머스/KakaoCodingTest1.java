package 프로그래머스;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class KakaoCodingTest1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] id;
        String[] report;
        int k;
        int[] ans;

        id = new String[]{"muzi", "frodo", "apeach", "neo"};
        report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        k = 2;
        ans = new int[]{2,1,1,0};
        assertThat(solution.solution(id, report, k)).isEqualTo(ans);

        id = new String[]{"con", "ryan"};
        report = new String[]{"ryan con", "ryan con", "ryan con", "ryan con"};
        k = 3;
        ans = new int[]{0,0};
        assertThat(solution.solution(id, report, k)).isEqualTo(ans);

    }

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            Map<String, Integer> reportCount = new HashMap<>();
            Map<String, Set<String>> reportHistory = new HashMap<>();

            for (String id: id_list) {
                Set<String> emptyReportList = new HashSet<>();
                reportHistory.put(id, emptyReportList);
            }

            for (String contents: report) {
                String[] user = contents.split(" ");
                Set<String> reportList = reportHistory.get(user[0]);
                reportList.add(user[1]);
                reportHistory.put(user[0], reportList);
            }

            Set<Map.Entry<String, Set<String>>> entries = reportHistory.entrySet();

            for (Map.Entry<String, Set<String>> entry : entries) {
                for (String reportId: entry.getValue()) {
                    if (reportCount.containsKey(reportId)) {
                        Integer point = reportCount.get(reportId) + 1;
                        reportCount.put(reportId, point);
                    } else {
                        reportCount.put(reportId, 1);
                    }
                }
            }

            List<String> suspendedId = new ArrayList<>();
            for (Map.Entry<String,Integer> entry : reportCount.entrySet()) {
                if (entry.getValue() >= k) {
                    suspendedId.add(entry.getKey());
                }
            }

            for (int i = 0; i < id_list.length; i++) {
                String id = id_list[i];
                int cnt = 0;
                for (String reportId : suspendedId) {
                    if (reportHistory.get(id).contains(reportId)) {
                        cnt++;
                    }
                }
                answer[i] = cnt;
            }

            return answer;
        }

    }
}
