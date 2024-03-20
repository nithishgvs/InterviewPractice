package interview.binarysearch;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays_1011 {

  public int shipWithinDays(int[] weights, int days) {
    int h = Arrays.stream(weights).reduce(0, (a, b) -> a + b);
    int l = Arrays.stream(weights).max().getAsInt();

    int weight = 0;
    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (canShipPackage(weights, days, mid)) {
        weight = mid;
        h = mid - 1;
      } else {
        l = mid + 1;
      }

    }

    return weight;
  }

  private boolean canShipPackage(int[] weights, int days, int mid) {
    int sum = 0;
    int daysNeeded = 1;
    for (int i = 0; i < weights.length; i++) {
      if (sum + weights[i] > mid) {
        daysNeeded++;
        sum = 0;
      }
      sum += weights[i];
    }
    return daysNeeded <= days;
  }
}
