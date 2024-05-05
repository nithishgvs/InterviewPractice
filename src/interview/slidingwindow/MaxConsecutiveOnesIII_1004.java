package interview.slidingwindow;

import org.junit.Test;

public class MaxConsecutiveOnesIII_1004 {

  public int longestOnes(int[] nums, int k) {

    int left = 0;
    int zeroes = 0;

    int start = 0;

    int max = 0;
    while (start < nums.length) {
      if (nums[start] == 0) {
        zeroes++;
      }
      while (zeroes > k) {
        if (nums[left] == 0) {
          zeroes--;
        }
        left++;
      }
      max = Math.max(max, start - left + 1);
      start++;
    }

    return max;

  }

  @Test
  public void test() {
    int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
    int[] nums1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
    System.out.println(longestOnes(nums1, 2));

  }

}
