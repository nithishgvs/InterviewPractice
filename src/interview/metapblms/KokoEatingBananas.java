package interview.metapblms;

import org.junit.Test;

import java.util.Arrays;

public class KokoEatingBananas {


    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);

        int low = 1;
        int high = piles[piles.length - 1];

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canEatBananasWithCurrentSpeed(piles, mid, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }


        return ans;

    }

    private boolean canEatBananasWithCurrentSpeed(int[] piles, int speed, int h) {
        double value = 0;
        for (int i = 0; i < piles.length; i++) {
            value += (Math.ceil(piles[i] * 1.0 / speed));
        }
        return (int) value <= h;
    }

    @Test
    public void test() {
        int[] piles = {3, 6, 7, 11};
        System.out.println(minEatingSpeed(piles, 8));
    }
}
