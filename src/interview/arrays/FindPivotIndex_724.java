package interview.arrays;

import java.util.Arrays;
import org.junit.Test;

public class FindPivotIndex_724 {


  public int pivotIndex(int[] nums) {
    int total = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
    int preFixSum = 0;

    for (int i = 0; i < nums.length; i++) {
      int rightSum = total - preFixSum - nums[i];
      if (preFixSum == rightSum) {
        return i;
      }
      preFixSum += nums[i];
    }

    return -1;
  }


  @Test
  public void test() {
    int[] nums = {1, 7, 3, 6, 5, 6};
    System.out.println(pivotIndex(nums));
  }

}
