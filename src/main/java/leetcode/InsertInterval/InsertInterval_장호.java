package leetcode.InsertInterval;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InsertInterval_장호 {
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
            List<int[]> left = new ArrayList<>();
            List<int[]> right = new ArrayList<>();
            List<int[]> overLab = new ArrayList<>();
            List<int[]> ans = new ArrayList<>();

            for (int[] interval : intervals) {
                if (interval[1] < newInterval[0]) {
                    left.add(interval);
                } else if (interval[0] > newInterval[1]) {
                    right.add(interval);
                } else {
                    overLab.add(interval);
                }
            }

            ans.addAll(left);
            ans.add(mergedInterval(overLab, newInterval));
            ans.addAll(right);

            return ans.toArray(new int[ans.size()][2]);
        }

        private int[] mergedInterval(List<int[]> overLab, int[] newInterval) {
            int[] mergedArr;
            mergedArr = newInterval;
            for (int[] value : overLab) {
                mergedArr[0] = Math.min(mergedArr[0], value[0]);
                mergedArr[1] = Math.max(mergedArr[1], value[1]);
            }
            return mergedArr;
        }
    }
}
