package 프로그래머스.코딩테스트;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NaverClovaCodingTest2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String S;
        int ans;

        S = "azABaabza";
        ans = 5;
        assertThat(solution.solution(S)).isEqualTo(ans);

    }

    static class Solution {
        public int solution(String S) {
            int answer = -1;
            for (int i = 2; i <= S.length(); i++) {
                for (int j = 0; j <= (S.length() - i); j++) {
                    Set<Character> charSet = new HashSet<>();
                    boolean isBalanced = true;

                    for (int k = j; k <= j+i-1; k++) {
                        charSet.add(S.charAt(k));
                    }

                    for (Character c : charSet) {
                        if (Character.isUpperCase(c)) {
                            if (!charSet.contains(c+32)) {
                                isBalanced = false;
                            }
                        } else if (c <= 'z' && c >= 'a') {
                            if (!charSet.contains(c-32)) {
                                isBalanced = false;
                            }
                        }
                    }
                    if (isBalanced) {
                        return S.substring(j, i).length();
                    }
                }
            }

            return answer;
        }

    }
}
