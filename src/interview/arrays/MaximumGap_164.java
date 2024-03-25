package interview.arrays;

import java.util.Arrays;
import org.junit.Test;

public class MaximumGap_164 {

  public int maximumGap(int[] nums) {

    int max = 0;

    if (nums.length < 2) {
      return max;
    }

    Arrays.sort(nums);

    for (int i = 1; i < nums.length; i++) {
      max = Math.max(max, Math.abs(nums[i] - nums[i - 1]));
    }

    return max;

  }


  @Test
  public void test() {

  }

}
