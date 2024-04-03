package interview.arrays;

import org.junit.Test;

public class RemoveDuplicatesfromSortedArrayII_80 {


  public int removeDuplicates(int[] nums) {

    var replaceIndex = 0;
    for (var i = 0; i < nums.length; i++) {
      if (replaceIndex - 2 >= 0 && nums[replaceIndex - 2] == nums[i]) {
        continue;
      }
      nums[replaceIndex] = nums[i];
      replaceIndex++;
    }
    return replaceIndex;
  }

  @Test
  public void test() {
    int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
    removeDuplicates(nums);
  }

}
