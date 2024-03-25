package interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class MinimumSubsequenceinNonIncreasingOrder_1403 {


  public List<Integer> minSubsequence(int[] nums) {

    List<Integer> result = new ArrayList<>();

    int total = Arrays.stream(nums).reduce(0, (a, b) -> a + b);

    Arrays.sort(nums);

    int sum = 0;

    for (int j = nums.length - 1; j > -1; j--) {
      sum += nums[j];
      result.add(nums[j]);
      if (total - sum < sum) {
        break;
      }

    }

    return result;

  }


  @Test
  public void test(){
    int[] nums={4,4,7,6,7};
    minSubsequence(nums);
  }

}
