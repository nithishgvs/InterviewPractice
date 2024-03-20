package interview.binarysearch;

public class FindFirstandLastPositionofElementInSortedArray_34 {

  public int[] searchRange(int[] nums, int target) {
    int[] result = new int[2];
    result[0] = helper(0, nums.length - 1, nums, target, true);
    result[1] = helper(0, nums.length - 1, nums, target, false);
    return result;
  }

  private int helper(int l, int h, int[] nums, int target, boolean fromLeft) {
    int ans = -1;
    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (nums[mid] == target) {
        //Found an index it can't be first or last
        ans = mid;
        if (fromLeft) {
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
