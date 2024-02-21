package interview.arrays;

import org.junit.Test;

public class MoveZeroes_283 {


  public void moveZeroes(int[] nums) {

    int insertIndexPosition = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[insertIndexPosition] = nums[i];
        insertIndexPosition++;
      }
    }

    while (insertIndexPosition < nums.length) {
      nums[insertIndexPosition] = 0;
      insertIndexPosition++;
    }
  }


  @Test
  public void test() {
    moveZeroes(new int[]{0, 1, 0, 3, 12});
  }

}
