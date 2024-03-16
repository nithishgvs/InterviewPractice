package interview.dynamicprogramming;

import org.junit.Test;

public class JumpGame_55 {


  //https://www.youtube.com/watch?v=Zb4eRjuPHbM
  public boolean canJump(int[] nums) {

    int lastPosition = nums.length - 1;

    //For an element to got to last position it should come from the last-1 nums.lenght-2
    //We put last index element as last position and we check if current index+nums[i] is greater than equal to last position we put the index as last position
    for (int i = lastPosition; i >= 0; i--) {
      if (i + nums[i] >= lastPosition) {
        lastPosition = i;
      }
    }

    return lastPosition == 0;

  }


  @Test
  public void test() {
    int[] nums = {2, 3, 1, 1, 4};
    int[] nums1 = {3, 2, 1, 0, 4};
    int[] nums2 = {0, 2, 3};
    System.out.println(canJump(nums2));

  }

}
