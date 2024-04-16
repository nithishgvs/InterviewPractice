package interview.arrays;

import java.util.Arrays;
import org.junit.Test;

public class CapacityToShipPackagesWithinDDays {

  public int shipWithinDays(int[] weights, int days) {

    int h = Arrays.stream(weights).sum();
    int l = Arrays.stream(weights).max().getAsInt();

    int result = 0;

    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (canShip(weights, days, mid)) {
        result = mid;
        h = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return result;
  }

  private boolean canShip(int[] weights, int days, int mid) {
    int sum = 0;
    int totalDaysNeeded = 1;
    for (int i = 0; i < weights.length; i++) {
      if (sum + weights[i] > mid) {
        sum = 0;
        totalDaysNeeded++;
      }
      sum += weights[i];
    }
    return totalDaysNeeded <= days;
  }


  @Test

  public void test() {
    int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    shipWithinDays(weights, 5);
  }

}
