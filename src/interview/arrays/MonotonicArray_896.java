package interview.arrays;

import org.junit.Test;

public class MonotonicArray_896 {

  public boolean isMonotonic(int[] nums) {

    if (nums.length <= 2) {
      return true;
    }

    boolean increasing = false;

    if (nums[1] > nums[0]) {
      increasing = true;
    }

    boolean edgeCase = false;

    if (nums[1] == nums[0]) {
      edgeCase = true;
    }

    for (int i = 2; i < nums.length; i++) {
      if (edgeCase) {
        if (nums[i] > nums[i - 1]) {
          increasing = true;
          edgeCase = false;
        } else if (nums[i] < nums[i - 1]) {
          increasing = false;
          edgeCase = false;
        }
        continue;
      }
      if (nums[i] >= nums[i - 1] && increasing) {
        continue;
      } else if (nums[i] <= nums[i - 1] && !increasing) {
        continue;
      } else {
        return false;
      }
    }
    return true;

  }

  @Test
  public void test() {
    int[] nums = {1, 1, 2};
    System.out.println(isMonotonic(nums));
  }


}
