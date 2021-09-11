package 프로그래머스;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class KaKaoCodingTest3 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] feed;
        String[] records;
        int[] ans;

        feed = new int[]{180, 5000, 10, 600};
        records = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        ans = new int[]{14600, 34400, 5000};
        assertThat(solution.solution(feed, records)).isEqualTo(ans);

    }

    static class Solution {
        public int[] solution(int[] fees, String[] records) {
            int[] answer;
            int defaultTime = fees[0];
            int defaultFee = fees[1];
            int basicUnit = fees[2];
            int unitFee = fees[3];

            Map<String, List<Integer>> parkingInfo = new HashMap<>();

            for (String info : records) {
                String[] carInfo = info.split(" ");
                String time = carInfo[0];
                String carNumber = carInfo[1];

                List<Integer> parkingTime = new ArrayList<>();
                if (parkingInfo.containsKey(carNumber)) {
                    parkingTime = parkingInfo.get(carNumber);
                }
                parkingTime.add(convertMinute(time));
                parkingInfo.put(carNumber, parkingTime);
            }

            Map<String, Integer> carToPay = new TreeMap<>();
            for (Map.Entry<String, List<Integer>> entry : parkingInfo.entrySet()) {
                if (entry.getValue().size() % 2 == 1) {
                    entry.getValue().add(convertMinute("23:59"));
                }

                int totalFee = defaultFee;
                int parkingTime = 0;
                for (int i = 1; i <= entry.getValue().size(); i+=2) {
                    parkingTime += entry.getValue().get(i) - entry.getValue().get(i-1);
                }
                if (parkingTime > defaultTime) {
                    if ((parkingTime - defaultTime) % basicUnit == 0) {
                        totalFee = defaultFee + (parkingTime - defaultTime) / basicUnit * unitFee;
                    } else {
                        totalFee = (defaultFee + (parkingTime - defaultTime) / basicUnit * unitFee) + unitFee;
                    }
                }
                carToPay.put(entry.getKey(), totalFee);
            }

            answer = new int[carToPay.size()];
            int i = 0;
            for (Integer fee : carToPay.values()) {
                answer[i] = fee;
                i++;
            }

            return answer;
        }

        static int convertMinute(String time) {
            String h = time.substring(0,2);
            String m = time.substring(3);

            int ret = 0;

            ret += Integer.parseInt(h)*60 ;
            ret += Integer.parseInt(m);

            return ret;
        }
    }

}
