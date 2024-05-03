package interview.heaps;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {

  public int findKthLargest(int[] nums, int k) {
    return quicksort(nums, 0, nums.length - 1, nums.length - k);
  }

  private int quicksort(int[] nums, int low, int high, int neededIndex) {

    if (low == high) {
      return nums[low];
    }
    int pivot = partition(nums, low, high);
    if (pivot == neededIndex) {
      return nums[neededIndex];
    }

    if (pivot > neededIndex) {
      return quicksort(nums, low, pivot - 1, neededIndex);
    }
    return quicksort(nums, pivot + 1, high, neededIndex);

  }


  public int partition(int[] nums, int low, int high) {
    int l = low;
    int h = high;
    int pivot = nums[low];

    while (l < h) {
      while (nums[l] <= pivot && l < h) {
        l++;
      }
      while (nums[h] > pivot) {
        h--;
      }

      if (l < h) {
        swapElem(nums, l, h);
      }
    }

    swapElem(nums, low, h);
    return h;
  }

  private void swapElem(int[] nums, int l, int h) {
    int tmp = nums[l];
    nums[l] = nums[h];
    nums[h] = tmp;
  }

}
