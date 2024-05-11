package interview.binarysearch;

import org.junit.Test;

public class FindPeakElement {


  public int findPeakElement(int[] nums) {

    if (nums.length == 1) {
      return 0;
    }

    int n = nums.length;

    if (nums[0] > nums[1]) {
      return 0;
    }

    if (nums[n - 1] > nums[n - 2]) {
      return n - 1;
    }

    int l = 1, h = nums.length - 2;

    while (l <= h) {

      int mid = l + (h - l) / 2;
      if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
        return mid;
      } else if (nums[mid - 1] > nums[mid]) {
        h = mid - 1;
      } else {
        l = mid + 1;
      }

    }

    return -1;

  }

  @Test
  public void test() {
    int[] nums = {1, 2, 3, 1};
    System.out.println(findPeakElement(nums));
  }

}
