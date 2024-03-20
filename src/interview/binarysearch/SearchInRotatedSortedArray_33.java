package interview.binarysearch;

public class SearchInRotatedSortedArray_33 {

  public int search(int[] nums, int target) {
    int l = 0;
    int h = nums.length - 1;

    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      //Check if left array is sorted
      if (nums[l] <= nums[mid]) {
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

}
