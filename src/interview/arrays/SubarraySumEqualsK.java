package interview.arrays;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class SubarraySumEqualsK {

  public int subarraySum(int[] nums, int k) {

    int count = 0;
    Map<Integer, Integer> prefixSum = new HashMap<>();
    prefixSum.put(0, 1);
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (prefixSum.containsKey(sum - k)) {
        count += prefixSum.get(sum - k);
      }

      prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
    }

    return count;

  }

  @Test
  public void test() {
    int[] nums = {1, 1, 1};
    System.out.println(subarraySum(nums, 2));
  }

}
