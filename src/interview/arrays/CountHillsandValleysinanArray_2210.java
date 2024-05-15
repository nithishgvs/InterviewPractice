package interview.arrays;

import org.junit.Test;

public class CountHillsandValleysinanArray_2210 {


  public int countHillValley(int[] nums) {
    int temp = nums[0];
    int count = 0;
    int len = nums.length - 1;

    for (int i = 0; i < len; i++) {

      while (i < len && nums[i] == nums[i + 1]) {
        i++;
      }

      if (i < len && hillsValleys(temp, nums[i], nums[i + 1])) {
        count++;
        temp = nums[i];
      }

    }

    return count;

  }

  private boolean hillsValleys(int left, int middle, int right) {

    if (left > middle && right > middle) {
      return true;
    }
    if (left < middle && right < middle) {
      return true;
    }

    return false;
  }


  @Test
  public void test() {
    int[] nums = {2, 4, 1, 1, 6, 5};
    System.out.println(countHillValley(nums));
  }

}
