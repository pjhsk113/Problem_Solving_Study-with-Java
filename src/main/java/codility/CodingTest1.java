package codility;

import static org.assertj.core.api.Assertions.assertThat;

public class CodingTest1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] T;
        int[] A;
        int ans;

        T = new int[] {0,3,0,0,5,0,5};
        A = new int[] {4,2,6,1,0};
        ans = 7;
        assertThat(solution.solution(T, A)).isEqualTo(ans);

        T = new int[] {0,0,1,1};
        A = new int[] {2};
        ans = 3;
        assertThat(solution.solution(T, A)).isEqualTo(ans);

        T = new int[] {0,0,0,0,1,2};
        A = new int[] {4, 5};
        ans = 5;
        assertThat(solution.solution(T, A)).isEqualTo(ans);

        T = new int[] {0,0,1,1,2,3};
        A = new int[] {4, 5};
        ans = 6;
        assertThat(solution.solution(T, A)).isEqualTo(ans);
    }

    static class Solution {
        public int solution(int[] T, int[] A) {
            int answer = 0;
            int[] count = new int[T.length];
            int index = 0;

            for (int element : A) {
                if (element == 0) {
                    continue;
                }

                index = T[element];

                while (index != 0) {
                    count[element]++;
                    count[T[element]]++;
                    index = T[index];

                    if (count[index] > 0) {
                        break;
                    }

                    count[index]++;
                }
            }

            for (int element : count) {
                answer += element;
            }

            return answer;
        }
    }
}
