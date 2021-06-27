package leetcode.townJudge;

import static org.assertj.core.api.Assertions.assertThat;

public class TownJudge_장호 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int N;
        int trust[][];
        int ans;

        N = 2;
        trust = new int[][]{{1, 2}};
        ans = 2;
        assertThat(solution.findJudge(N, trust)).isEqualTo(ans);

        N = 3;
        trust = new int[][]{{1, 3}, {2, 3}};
        ans = 3;
        assertThat(solution.findJudge(N, trust)).isEqualTo(ans);

        N = 3;
        trust = new int[][]{{1, 3}, {2, 3}, {3, 1}};
        ans = -1;
        assertThat(solution.findJudge(N, trust)).isEqualTo(ans);

        N = 3;
        trust = new int[][]{{1, 2}, {2, 3}};
        ans = -1;
        assertThat(solution.findJudge(N, trust)).isEqualTo(ans);
    }

    static class Solution {
        public int findJudge(int N, int[][] trust) {
            int n[][] = new int[N][2];
            for (int i = 0; i < N; i++) {
                n[i][0] = i + 1;
            }

            for (int i = 0; i < trust.length; i++) {
                n[trust[i][0] -1][0] = 0;
                n[trust[i][1] -1][1]++;
            }

            for (int[] ans : n) {
                if (ans[0] != 0 && ans[1] == (N - 1)) {
                    return ans[0];
                }
            }
            return -1;
        }
    }
}
