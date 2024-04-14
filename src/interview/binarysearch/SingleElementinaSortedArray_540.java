package interview.binarysearch;

import org.junit.Test;

public class SingleElementinaSortedArray_540 {


  public int singleNonDuplicate(int[] nums) {

    if (nums.length == 1) {
      return nums[0];
    }

    return binarySearch(nums, 0, nums.length - 1);

  }

  private int binarySearch(int[] nums, int l, int h) {
    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (mid - 1 > -1 && (mid + 1) < nums.length - 1 && (nums[mid] != nums[mid - 1]
          && nums[mid] != nums[mid + 1])) {
        return nums[mid];
      } else if (mid == 0 && nums[mid] != nums[mid + 1]) {
        return nums[mid];
      } else if (mid == nums.length - 1 && nums[mid] != nums[mid - 1]) {
        return nums[mid];
      }
      int value = binarySearch(nums, l, mid - 1);
      if (value == -1) {
        return binarySearch(nums, mid + 1, h);
      } else {
        return value;
      }
    }
    return -1;
  }


  @Test
  public void test() {
    int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
    System.out.println(singleNonDuplicate(nums));
  }

  @Test
  public void test2() {
    int[] nums = {3, 3, 7, 7, 10, 11, 11};
    System.out.println(singleNonDuplicate(nums));
  }

  @Test
  public void test3() {
    int[] nums = {1};
    System.out.println(singleNonDuplicate(nums));
  }


}
