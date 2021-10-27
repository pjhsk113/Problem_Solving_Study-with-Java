package 프로그래머스.level2;

import static org.assertj.core.api.Assertions.assertThat;

public class 피로도 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int k;
        int[][] dungeons;
        int answer;

        k = 80;
        dungeons = new int[][]{{80,20},{50,40},{30,10}};
        answer = 3;

        assertThat(solution.solution(k, dungeons)).isEqualTo(answer);

    }
    static class Solution {
        public static boolean check[];
        public static int ans = 0;

        public int solution(int k, int[][] dungeons) {
            check = new boolean[dungeons.length];

            dfs(k, dungeons, 0);

            return ans;
        }
        public static void dfs(int tired, int[][] dungeons, int cnt){

            for(int i=0; i<dungeons.length; i++){
                if(!check[i] && dungeons[i][0]<=tired){
                    check[i] = true;
                    dfs(tired-dungeons[i][1], dungeons, cnt+1);
                    check[i] = false;
                }
            }
            ans = Math.max(ans, cnt);
        }
    }
}
