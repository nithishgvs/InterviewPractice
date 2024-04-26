package interview.binarysearch;

public class CheckIfaNumberIsMajorityElementinaSortedArray_1150 {


  public boolean isMajorityElement(int[] nums, int target) {
    int maxIndex = Math.max(0, binarySearchHelper(nums, target, false));
    int minIndex = Math.max(0, binarySearchHelper(nums, target, true));

    if (maxIndex == 0 && minIndex == 0) {
      return false;
    }

    return (maxIndex - minIndex + 1) > (nums.length / 2);
  }

  private int binarySearchHelper(int[] nums, int target, boolean isLeft) {

    int l = 0, h = nums.length - 1;

    int ans = -1;

    while (l <= h) {
      int mid = l + (h - l) / 2;

      if (nums[mid] == target) {
        ans = mid;
        if (isLeft) {
          h = mid - 1;
        } else {
          l = mid + 1;
        }
      } else if (nums[mid] > target) {
        h = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return ans;
  }
}
