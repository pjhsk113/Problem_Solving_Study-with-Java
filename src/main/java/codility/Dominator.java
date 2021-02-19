package codility;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Dominator {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        List<Integer> ans;
        int expected;

        A = new int[]{3,4,3,2,3,-1,3,3};
        ans = Arrays.asList(0,2,4,6,7);
        expected = solution.solution(A);
        assertThat(ans.contains(expected)).isTrue();

    }

    static class Solution {
        public int solution(int[] A) {
            Map<Integer, Integer> map = new HashMap<>();
            int halfLength = A.length / 2;
            int ans = -1;

            for (int a : A) {
                if (map.containsKey(a)) {
                    Integer value = map.get(a);
                    map.put(a, ++value);
                } else {
                    Integer value = 1;
                    map.put(a, value);
                }
            }

            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

            for (Map.Entry<Integer, Integer> entry : entries) {
                if (entry.getValue() > halfLength) {
                    ans = entry.getKey();
                    break;
                }
            }

            for (int i = 0; i < A.length; i++) {
                if (ans == A[i]) {
                    return i;
                }
            }

            return ans;
        }
    }
}
