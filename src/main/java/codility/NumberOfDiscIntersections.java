package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfDiscIntersections {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int ans;

        A = new int[]{1, 5, 2, 1, 4, 0};
        ans = 11;
        assertThat(solution.solution(A)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(int[] A) {
            int length = A.length;
            long[] start = new long[length];
            long[] end = new long[length];
            int ans = 0;
            int j = 0;


            for (int i = 0; i < length; i++) {
                start[i] = i - (long)A[i];
                end[i] = i + (long)A[i];
            }

            Arrays.sort(start);
            Arrays.sort(end);

            for (int i = 0; i < length; i++) {
                while (j < length && end[i] >= start[j]) {
                    ans += j;
                    ans -= i;
                    j++;
                }
            }

            if (ans > 10000000) {
                return -1;
            }

            return ans;
        }

    }
}
