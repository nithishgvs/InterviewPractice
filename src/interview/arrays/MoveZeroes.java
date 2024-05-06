package interview.arrays;

import org.junit.Test;

public class MoveZeroes {

  public void moveZeroes(int[] nums) {

    int idx = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[idx++] = nums[i];
      }
    }

    while (idx < nums.length) {
      nums[idx++] = 0;
    }
  }

  @Test
  public void test() {
    moveZeroes(new int[]{0, 1, 0, 3, 12});
  }


}
