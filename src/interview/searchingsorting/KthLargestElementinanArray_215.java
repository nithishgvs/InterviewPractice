package interview.searchingsorting;


import org.junit.Test;

public class KthLargestElementinanArray_215 {

  public int findKthLargest(int[] nums, int k) {
    return quicksort(nums, 0, nums.length - 1, nums.length - k);
  }

  private int quicksort(int[] nums, int low, int high, int interestedIndex) {

    if (low == high) {
      return nums[low];
    }

    int pivotIndex = partition(nums, low, high);

    if (pivotIndex == interestedIndex) {
      return nums[pivotIndex];
    }

    if (pivotIndex > interestedIndex) {
      return quicksort(nums, low, pivotIndex - 1, interestedIndex);
    }
    return quicksort(nums, pivotIndex + 1, high, interestedIndex);
  }

  private int partition(int[] nums, int l, int h) {
    int low = l;
    int high = h;
    int pivot = nums[l];

    while (low < high) {

      while (low < high && nums[low] <= pivot) {
        low++;
      }

      while (nums[high] > pivot) {
        high--;
      }

      if (low < high) {
        swap(low, high, nums);
      }
    }

    swap(l, high, nums);

    return high;
  }


  public static void swap(int i, int j, int[] arr) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


  @Test
  public void test() {
    System.out.println(findKthLargest(new int[]{5, 6, 0, 1}, 2));
  }
}
