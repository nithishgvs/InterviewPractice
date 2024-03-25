package interview.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import org.junit.Test;

public class PartitionEqualSubsetSum_416 {


  int total = 0;

  public boolean canPartition(int[] nums) {

    total = Arrays.stream(nums).reduce(0, (a, b) -> a + b);

    if (total % 2 != 0) {
      return false;
    }

    return helper(nums, 0, 0, new HashMap<>());

  }

  private boolean helper(int[] nums, int index, int sum, HashMap<String, Boolean> dp) {
    String current = index + "|" + sum;
    if (sum * 2 == total) {
      return true;
    }
    if (dp.containsKey(current)) {
      return dp.get(current);
    }

    if (sum > total / 2 || index >= nums.length) {
      return false;
    }

    boolean value =
        helper(nums, index + 1, sum + nums[index], dp) || helper(nums, index + 1, sum, dp);
    dp.put(current, value);

    return value;
  }


  @Test
  public void test() {
    int[] nums = {1, 2, 5};
    canPartition(nums);

  }


}
