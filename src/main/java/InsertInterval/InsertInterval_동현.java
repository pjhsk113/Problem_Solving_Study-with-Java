package InsertInterval;

import static org.assertj.core.api.Assertions.assertThat;

public class InsertInterval_동현 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int intervals[][];
        int newInterval[];
        int ans[][];

        intervals = new int[][] {{1, 3},{6, 9}};
        newInterval = new int[] {2, 5};
        ans = new int[][] {{1, 5}, {6, 9}};
        assertThat(solution.insert(intervals, newInterval)).isEqualTo(ans);

        intervals = new int[][] {{1, 2},{3, 4},{6, 7},{8, 10},{12, 16}};
        newInterval = new int[] {4, 8};
        ans = new int[][] {{1, 2}, {3, 10}, {12, 16}};
        assertThat(solution.insert(intervals, newInterval)).isEqualTo(ans);

        intervals = new int[][] {};
        newInterval = new int[] {5, 7};
        ans = new int[][] {{5, 7}};
        assertThat(solution.insert(intervals, newInterval)).isEqualTo(ans);

        intervals = new int[][] {{1, 5}};
        newInterval = new int[] {2, 3};
        ans = new int[][] {{1, 5}};
        assertThat(solution.insert(intervals, newInterval)).isEqualTo(ans);

        intervals = new int[][] {{1, 5}};
        newInterval = new int[] {2, 7};
        ans = new int[][] {{1, 7}};
        assertThat(solution.insert(intervals, newInterval)).isEqualTo(ans);
    }

    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int ans[][] = new int[][] {{0}};

            return ans;
        }
    }
}
