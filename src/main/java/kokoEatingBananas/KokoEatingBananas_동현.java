package kokoEatingBananas;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class KokoEatingBananas_동현 {
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
            int left = 1;
            int right = Arrays.stream(piles).max().getAsInt();
            while(left <= right) {
                int mid = (left + right) / 2;

                int eatHour = howTakeLongToEat(mid,piles);

                if(eatHour > H) {
                    left = mid + 1;
                }

                if(eatHour <= H) {
                    right = mid - 1;
                }

            }
            return left;
        }

        int howTakeLongToEat(int k,int[] piles) {
            int ans = 0;
            for (int pile : piles) {
                int hour = 0;
                if (pile % k == 0) {
                    hour = pile / k;
                } else {
                    hour = pile / k + 1;
                }
                ans += hour;
            }
            return ans;
        }
    }
}
