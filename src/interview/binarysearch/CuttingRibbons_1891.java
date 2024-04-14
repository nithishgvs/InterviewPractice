package interview.binarysearch;

import java.util.Arrays;
import org.junit.Test;

public class CuttingRibbons_1891 {

  public int maxLength(int[] ribbons, int k) {

    int max = 0;
    int h = Arrays.stream(ribbons).max().getAsInt();
    int l = 1;
    Arrays.sort(ribbons);
    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (canCut(ribbons, mid) >= k) {
        max = mid;
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }

    return max;
  }

  private int canCut(int[] ribbons, int mid) {
    int sum = 0;
    for (int rib : ribbons) {
      sum += rib / mid;
    }
    return sum;
  }

  @Test
  public void test() {
    int[] nums = {7, 5, 9};
    System.out.println(maxLength(nums, 4));
  }

}
