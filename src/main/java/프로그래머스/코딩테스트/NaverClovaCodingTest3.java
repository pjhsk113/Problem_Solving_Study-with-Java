package 프로그래머스.코딩테스트;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class NaverClovaCodingTest3 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String S;
        int ans;

        S = "CODILIDY";
        ans = 96;
        assertThat(solution.solution(S)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(String S) {
            final int MOD = 1000000007;
            Map<Character, List<Integer>> index = new HashMap<>();
            for (int i = 0; i < S.length(); i++) {
                index.computeIfAbsent(S.charAt(i), x -> new ArrayList<>()).add(i);
            }

            int sum = 0;
            for (List<Integer> list : index.values()) {
                for (int i = 0; i < list.size(); i++) {

                    int left = i == 0 ? -1 : list.get(i - 1);   // 左边界
                    int right = i == list.size() - 1 ? S.length() : list.get(i + 1);    // 右边界
                    sum = (sum + (list.get(i) - left) * (right - list.get(i))) % MOD;
                }
            }
            return sum;
        }
    }
}
