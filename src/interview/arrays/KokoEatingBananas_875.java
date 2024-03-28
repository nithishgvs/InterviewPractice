package interview.arrays;

import java.util.Arrays;

public class KokoEatingBananas_875 {

  public int minEatingSpeed(int[] piles, int h) {
    Arrays.sort(piles);
    int low = 0, high = piles[piles.length - 1];
    int speed = Integer.MAX_VALUE;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (canEatBananas(mid, piles, h)) {
        speed = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return speed;
  }

  private boolean canEatBananas(int speed, int[] piles, int h) {
    double time = 0;
    for (int p : piles) {
      time += (int) Math.ceil(p * 1.0 / speed);
    }
    return (int) time <= h;
  }

}
