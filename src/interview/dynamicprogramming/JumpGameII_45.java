package interview.dynamicprogramming;

import java.util.Arrays;
import org.junit.Test;

public class JumpGameII_45 {


  public int jump(int[] nums) {

    int[] jumps = new int[nums.length];
    Arrays.fill(jumps, Integer.MAX_VALUE);
    jumps[0] = 0;

    for (int i = 1; i <= nums.length - 1; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] + j >= i) {
          jumps[i] = Math.min(jumps[i], 1 + jumps[j]);
        }
      }
    }

    return jumps[nums.length - 1];

  }


  @Test
  public void test() {
    int[] nums = {2, 3, 1, 1, 4};
    int[] nums1 = {3, 2, 1, 0, 4};
    int[] nums2 = {0, 2, 3};
    System.out.println(jump(nums));

  }

}
