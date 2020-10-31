package 카펫;

import static org.assertj.core.api.Assertions.assertThat;

public class 카펫_장호 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int brown;
        int yellow;
        int[] answer;

        brown = 10;
        yellow = 2;
        answer = new int[] {4, 3};

        assertThat(solution.solution(brown, yellow)).containsExactly(answer);

        brown = 8;
        yellow = 1;
        answer = new int[] {3, 3};

        assertThat(solution.solution(brown, yellow)).containsExactly(answer);

        brown = 24;
        yellow = 24;
        answer = new int[] {8, 6};

        assertThat(solution.solution(brown, yellow)).containsExactly(answer);


    }

    /**
     * 이것도 수학 비슷한 문제 ㅠ
     * brown과 yellow의 규칙을 찾아 공식화하여 품
     *
     * brown == (가로 *2) + (세로 -2) *2
     * yellow == 가로-2 * 세로-2
     */
    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            int width = brown + yellow;

            /* 약수를 찾아서 가로와 세로 길이를 구한다
            *  가로가 세로보다 짧은 경우는 없으므로 뒤에서 부터 반복문을 시작
            *  i = 가로길이,  전체넓이 / i(가로길이) = 세로길이 */
            for (int i = width; i >= width/i; i--) {
                // 약수일 경우에만 계산 진행
                if (width % i != 0) {
                    continue;
                }

                if (brown == (i * 2) + (((width/i) - 2) * 2) && yellow == (i - 2) * ((width/i) - 2)) {
                    answer[0] = i;
                    answer[1] = width/i;
                    break;
                }
            }
            return answer;
        }
    }
}
