package interview.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;


public class ContinuousSubarraySum {


  public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    int sum = 0;

    map.put(0, -1);

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int remainder = sum % k;

      if (map.containsKey(remainder)) {
        if (i - map.get(remainder) >= 2) {
          return true;
        }
      } else {
        map.put(remainder, i);
      }
    }

    return false;
  }

  @Test
  public void test() {
    int[] nums = {23, 2, 6, 4, 7};

    System.out.println(Arrays.stream(nums).sum());
    checkSubarraySum(nums, 6);

  }
}
