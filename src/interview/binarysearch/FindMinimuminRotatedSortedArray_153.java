package interview.binarysearch;

import java.util.Arrays;
import org.junit.Test;

public class FindMinimuminRotatedSortedArray_153 {


  public int findMin(int[] nums) {
    int n = nums.length;
    int beg = 0, end = n - 1;
    while (beg < end) {
      int mid = (beg + end) / 2;
      if (nums[mid] > nums[n - 1])  //ans is in right
      {
        beg = mid + 1;  // means we are in first array
      } else if (nums[mid] <= nums[n - 1]) { // means we are in second array
        end = mid;
      }
    }
    return nums[beg];
  }


  @Test
  public void test() {
    int[] nums = {4, 5, 6, 7, 0};
    System.out.println(findMin(nums));
  }

}
