package interview.arrays;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class MaximumSubarray_53 {


  public int maxSubArray(int[] nums) {

    int max = nums[0];
    int sum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      /**
       * As this is contiguous we need to add the current num nums[i]
       *
       * We check if previous sum with nums[i] is greater than nums[i] if yes we pick the current number and add it to the sum
       *
       * else sum becomes current number
       */
      sum = Math.max(sum + nums[i], nums[i]);
      max = Math.max(max, sum);
    }

    return max;

  }


  @Test
  public void test() {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(nums));
  }


}
