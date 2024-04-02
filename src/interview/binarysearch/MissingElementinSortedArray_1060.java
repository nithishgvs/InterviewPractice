package interview.binarysearch;

import org.junit.Test;

public class MissingElementinSortedArray_1060 {

  //https://www.youtube.com/watch?v=uZ0N_hZpyps
  public int missingElement(int[] nums, int k) {

    int l = 0, h = nums.length - 1;

    while (l <= h) {
      int mid = l + (h - l) / 2;
      int missingNums = nums[mid] - (nums[0] + mid);
      if (missingNums < k) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }

    }

    //Number plus missing net
    return nums[h] + k - (nums[h] - (nums[0] + h));

  }

  @Test
  public void test() {
    int[] nums = {4, 7, 9, 10};
    System.out.println(missingElement(nums, 5));
  }

}
