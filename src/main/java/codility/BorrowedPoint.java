package codility;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BorrowedPoint {
    public static void main(String[] args) {
        List<List<String>> arr = new ArrayList<>();

        List<String> a = Arrays.asList("a", "b", "1");
        List<String> b = Arrays.asList("b", "c", "5");
        List<String> c = Arrays.asList("a", "c", "3");

        arr.add(a);
        arr.add(b);
        arr.add(c);

        List<String> ans = Arrays.asList("a", "b");

        assertThat(solution(arr)).isEqualTo(ans);

    }

    public static List<String> solution(List<List<String>> arr) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> points = new HashMap<>();

        for (List<String> record: arr) {
            Integer value = Integer.parseInt(record.get(2));
            if (points.containsKey(record.get(0))) {
                Integer point = points.get(record.get(0)) - value;
                points.put(record.get(0), point);
            } else {
                points.put(record.get(0), -value);
            }

            if (points.containsKey(record.get(1))) {
                Integer point = points.get(record.get(1)) + value;
                points.put(record.get(1), point);
            } else {
                points.put(record.get(1), value);
            }
        }

        int min = Collections.min(points.values());
        Set<Map.Entry<String, Integer>> entries = points.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() < 0 && entry.getValue() <= min) {
                answer.add(entry.getKey());
            }
        }

        if (answer.isEmpty()) {
            answer.add("None");
            return answer;
        }

        Collections.sort(answer);

        return answer;
    }
}
