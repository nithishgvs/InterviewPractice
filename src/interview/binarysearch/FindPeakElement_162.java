package interview.binarysearch;

public class FindPeakElement_162 {

  public int findPeakElement(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }

    return peakHelper(nums, 0, nums.length - 1);
  }

  private int peakHelper(int[] nums, int l, int h) {

    while (l <= h) {

      int mid = l + (h - l) / 2;

      if (mid + 1 < nums.length && mid - 1 > -1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
        return mid;
      } else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
        return mid;
      } else if (mid == 0 && nums[mid] > nums[mid + 1]) {
        return mid;
      } else {
        int peakLeft = peakHelper(nums, l, mid - 1);
        if (peakLeft != -1) {
          return peakLeft;
        } else {
          return peakHelper(nums, mid + 1, h);
        }
      }
    }

    return -1;
  }

}
