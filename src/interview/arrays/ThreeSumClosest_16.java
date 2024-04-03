package interview.arrays;

import java.util.Arrays;
import org.junit.Test;

public class ThreeSumClosest_16 {


  public int threeSumClosest(int[] nums, int target) {

    int closest = Integer.MAX_VALUE;
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      int l = i + 1;
      int h = nums.length - 1;

      while (l < h) {
        int sum = nums[i] + nums[l] + nums[h];
        if (Math.abs(target - sum) < Math.abs(target - closest)) {
          closest = sum;
        }
        if (sum > target) {
          h--;
        } else {
          l++;
        }
      }

    }

    return closest;

  }

  @Test
  public void test() {
    int[] nums = {-1, 2, 1, -4};
    threeSumClosest(nums, 1);
  }
}
