package interview.arrays;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class SubarraySumEqualsK_560 {

  public int subarraySum(int[] nums, int k) {
    int result = 0;

    Map<Integer, Integer> sumMap = new HashMap<>();
    sumMap.put(0, 1);

    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sumMap.containsKey(sum - k)) {
        result += sumMap.get(sum - k);
      }
      sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
    }
    return result;
  }

  @Test
  public void test() {
    int[] nums = {1, 1, 1};
    System.out.println(subarraySum(nums, 2));
  }

}
