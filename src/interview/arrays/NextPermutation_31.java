package interview.arrays;

import org.junit.Test;

public class NextPermutation_31 {


  public void nextPermutation(int[] nums) {
    //First we need to find the decreasing sequence of the nums from the last
    //After we encounter the index we swap with the least  element from the last
    //Then we reverse from index+1

    int i = nums.length - 2;

    while (i >= 0 && nums[i + 1] <= nums[i]) {
      i--;
    }

    //By now we will have where the increasing sequence ended
    //Now we swap the last least integer with index i (decreasing sequence ended here)
    //Here if array is in decreasing order 3,2,1 next would we 1,2,3 we dont need any swaps just reverse
    //After we swap we reverse the array after i so it will be in decreasing order

    if (i >= 0) {
      int j = nums.length - 1;

      while (j >= 0 && nums[j] <= nums[i]) {
        j--;
      }
      //swap i with j
      swap(nums, i, j);
    }

    reverse(nums, i + 1);
  }

  private void reverse(int[] nums, int index) {
    int left = index;
    int right = nums.length - 1;

    while (left < right) {
      swap(nums, left, right);
      left++;
      right--;
    }
  }


  private void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }

  @Test
  public void test() {
    int[] nums = {1, 5, 2};
    nextPermutation(nums);
  }
}

