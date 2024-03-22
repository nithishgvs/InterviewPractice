package interview.slidingwindow;

import org.junit.Test;

public class MaxConsecutiveOnesIII_1004 {

  public int longestOnes(int[] nums, int k) {

    int max = 0;

    int startIndex = 0;
    int currentIndex = 0;
    int temp = 0;

    while (currentIndex < nums.length) {
      if (nums[currentIndex] == 0) {
        temp++;
      }

      while (temp > k) {
        if (nums[startIndex] == 0) {
          temp--;
        }
        startIndex++;
      }

      max = Math.max(max, currentIndex - startIndex + 1);

      currentIndex++;
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
