package interview.arrays;

import org.junit.Test;

public class MergeSortedArray {


  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int nums1Index = m - 1, nums2Index = n - 1;
    int totalIndex = m + n - 1;

    while (nums2Index >= 0) {
      if (nums1Index >= 0 && nums1[nums1Index] > nums2[nums2Index]) {
        nums1[totalIndex--] = nums1[nums1Index--];
      } else {
        nums1[totalIndex--] = nums2[nums2Index--];
      }
    }
  }


  @Test
  public void test() {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    merge(nums1, 3, nums2, 3);
  }

}
