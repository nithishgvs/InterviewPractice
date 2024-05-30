package interview.binarysearch;

import org.junit.Test;

public class SearchinRotatedSortedArray {

  public int search(int[] nums, int target) {

    int l = 0;
    int h = nums.length - 1;

    while (l <= h) {

      int mid = l + (h - l) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      if (nums[l] <= nums[mid]) {
        //Left sub array is sorted
        if (nums[l] <= target && target <= nums[mid]) {
          h = mid - 1;
        } else {
          l = mid + 1;
        }
      } else {
        if (nums[mid + 1] <= target && nums[h] >= target) {
          l = mid + 1;
        } else {
          h = mid - 1;
        }
      }
    }

    return -1;

  }


  @Test
  public void test() {
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    System.out.println(search(nums, 0));
  }

}
