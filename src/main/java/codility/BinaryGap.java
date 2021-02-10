package codility;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryGap {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n;
        int ans;

        n = 561892;
        ans = 3;
        assertThat(solution.solution(n)).isEqualTo(ans);

        n = 5;
        ans = 1;
        assertThat(solution.solution(n)).isEqualTo(ans);

        n = 1162;
        ans = 3;
        assertThat(solution.solution(n)).isEqualTo(ans);
    }

    static class Solution {
        public int solution(int N) {
            final String DELIMITER = "1";

            String binary = Integer.toBinaryString(N);
            String[] binaryArr = binary.split(DELIMITER);
            int length = binaryArr.length;
            int maxLength = 0;


            if (!binary.endsWith(DELIMITER)) {
                binaryArr[length-1] = "";
            }

            for (int i = 0; i < length; i++) {
                if (maxLength < binaryArr[i].length()) {
                    maxLength = binaryArr[i].length();
                }
            }

            return maxLength;
        }
    }
}
