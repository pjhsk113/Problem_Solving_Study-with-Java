package deletingLetters;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class DeletingLetters_장호 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s;
        int cost[];
        int ans;

        s = "abaac";
        cost = new int[]{1, 2, 3, 4, 5};
        ans = 3;
        assertThat(solution.minCost(s, cost)).isEqualTo(ans);

        s = "abc";
        cost = new int[]{1, 2, 3};
        ans = 0;
        assertThat(solution.minCost(s, cost)).isEqualTo(ans);

        s = "aabaa";
        cost = new int[]{1, 2, 3, 4, 1};
        ans = 2;
        assertThat(solution.minCost(s, cost)).isEqualTo(ans);
    }
    static class Solution {
        public int minCost(String s, int[] cost) {
            int cnt = 0, index = 0;
            char ss[] = s.toCharArray();
            ArrayDeque dq = new ArrayDeque();

            for (int i = 0; i < s.length();i++) {
                if (dq.isEmpty()) {
                    dq.add(ss[i]);
                    continue;
                }
                if (dq.peekLast().equals(ss[i])) {
                    cnt += Math.min(cost[index], cost[i]);
                    if (cost[index] < cost[i]) {
                        index = i;
                    }
                } else {
                    dq.add(ss[i]);
                    index = i;
                }
            }
            return cnt;
        }
    }
}
