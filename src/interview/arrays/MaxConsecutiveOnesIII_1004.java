package interview.arrays;

import org.junit.Test;

public class MaxConsecutiveOnesIII_1004 {


  public int longestOnes(int[] nums, int k) {

    int max = 0;
    int zeroes = 0;
    int start = 0;
    int startIndex = 0;

    while (start < nums.length) {
      if (nums[start] == 0) {
        zeroes++;
      }
      while (zeroes > k) {
        if (nums[startIndex] == 0) {
          zeroes--;
        }
        startIndex++;
      }

      max = Math.max(max, start - startIndex + 1);
      start++;
    }

    return max;
  }

  @Test
  public void test() {
    int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
    System.out.println(longestOnes(nums, 2));
  }

}
