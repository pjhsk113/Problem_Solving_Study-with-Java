package kokoEatingBananas;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class KokoEatingBananas_장호 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int piles[];
        int H;
        int ans;

        piles = new int[]{3, 6, 7, 11};
        H = 8;
        ans = 4;
        assertThat(solution.minEatingSpeed(piles,H)).isEqualTo(ans);

        piles = new int[]{30, 11, 23, 4, 20};
        H = 5;
        ans = 30;
        assertThat(solution.minEatingSpeed(piles,H)).isEqualTo(ans);

        piles = new int[]{30, 11, 23, 4, 20};
        H = 6;
        ans = 23;
        assertThat(solution.minEatingSpeed(piles,H)).isEqualTo(ans);

        piles = new int[]{312884470};
        H = 312884469;
        ans = 2;
        assertThat(solution.minEatingSpeed(piles,H)).isEqualTo(ans);
    }
    static class Solution {
        public int minEatingSpeed(int[] piles, int H) {
            if (piles.length == H) {
                return piles[piles.length - 1];
            }

            Arrays.sort(piles);
            int left = 1, right = piles[piles.length -1];
            int mid = 0, cnt = 0;

            while(left <= right) {
                mid = (left + right) / 2;
                cnt = 0;

                for (int pile : piles) {
                    cnt += pile / mid;
                    if (pile % mid != 0) {
                        cnt++;
                    }
                }

                if (cnt <= H) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
