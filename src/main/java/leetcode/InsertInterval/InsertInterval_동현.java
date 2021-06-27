package leetcode.InsertInterval;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class InsertInterval_동현 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int intervals[][];
        int newInterval[];
        int ans[][];

        intervals = new int[][]{{1, 5}};
        newInterval = new int[]{0, 0};
        ans = new int[][]{{0, 0},{1,5}};
        assertThat(solution.insert(intervals, newInterval)).isEqualTo(ans);

        intervals = new int[][]{{1, 3}, {6, 9}};
        newInterval = new int[]{2, 5};
        ans = new int[][]{{1, 5}, {6, 9}};
        assertThat(solution.insert(intervals, newInterval)).isEqualTo(ans);

        intervals = new int[][]{{1, 2}, {3, 4}, {6, 7}, {8, 10}, {12, 16}};
        newInterval = new int[]{4, 8};
        ans = new int[][]{{1, 2}, {3, 10}, {12, 16}};
        assertThat(solution.insert(intervals, newInterval)).isEqualTo(ans);

        intervals = new int[][]{};
        newInterval = new int[]{5, 7};
        ans = new int[][]{{5, 7}};
        assertThat(solution.insert(intervals, newInterval)).isEqualTo(ans);

        intervals = new int[][]{{1, 5}};
        newInterval = new int[]{2, 3};
        ans = new int[][]{{1, 5}};
        assertThat(solution.insert(intervals, newInterval)).isEqualTo(ans);

        intervals = new int[][]{{1, 5}};
        newInterval = new int[]{2, 7};
        ans = new int[][]{{1, 7}};
        assertThat(solution.insert(intervals, newInterval)).isEqualTo(ans);


    }

    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<Interval> selectInterval = new ArrayList<>();
            List<Interval> ansInterval = new LinkedList<>();

            for (int i = 0; i < intervals.length; i++) {
                int min = intervals[i][0];
                int max = intervals[i][1];
                if (isNewIntervalRange(min, max, newInterval)) {
                    selectInterval.add(new Interval(min, max, i));
                } else {
                    ansInterval.add(new Interval(min, max));
                }
            }

            if (!selectInterval.isEmpty()) {
                Interval mergedInterval = findNewInterval(selectInterval, newInterval);

                ansInterval.add(selectInterval.get(0).index, mergedInterval);
            } else {
                ansInterval.add(new Interval(newInterval[0], newInterval[1]));
            }




            int ans[][] = new int[ansInterval.size()][2];
            for(int i=0; i<ansInterval.size(); i++) {
                ans[i][0] = ansInterval.get(i).left;
                ans[i][1] = ansInterval.get(i).right;
            }
            Arrays.sort(ans, Comparator.comparingInt(num -> num[0]));
            return ans;
        }

        private Interval findNewInterval(List<Interval> selectInterval, int[] newInterval) {
            if (selectInterval.isEmpty())
                return null;

            int left = Math.min(selectInterval.get(0).left, newInterval[0]);
            int right = Math.max(selectInterval.get(selectInterval.size() - 1).right, newInterval[1]);
            return new Interval(left, right);
        }

        public boolean isNewIntervalRange(int originLeft, int originRight, int[] newInterval) {
            int newIntervalLeft = newInterval[0];
            int newIntervalRight = newInterval[1];
            for (int i = originLeft; i <= originRight; i++) {
                if (newIntervalLeft <= i && i <= newIntervalRight) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Interval {
        int left;
        int right;
        int index;

        public Interval(int left, int right, int index) {
            this.left = left;
            this.right = right;
            this.index = index;
        }

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "left=" + left +
                    ", right=" + right +
                    ", index=" + index +
                    '}';
        }
    }
}
