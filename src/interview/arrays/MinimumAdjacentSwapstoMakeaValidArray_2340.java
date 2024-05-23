package interview.arrays;

import org.junit.Test;

public class MinimumAdjacentSwapstoMakeaValidArray_2340 {

  public int minimumSwaps(int[] nums) {

    int largest = Integer.MIN_VALUE;
    int smallest = Integer.MAX_VALUE;

    int largeIdx = 0;
    int smallIdx = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < smallest) {
        smallest = nums[i];
        smallIdx = i;
      }
      if (nums[i] >= largest) {
        largest = nums[i];
        largeIdx = i;
      }

    }

    //Now for the smallest element to be placed in the 0th index we need n-1 swaps
    //For the largest index swaps equal to length n-currIndex

    int n = nums.length - 1;//Index non inclusive starts at 0th

    int res = n - largeIdx + smallIdx;

    //We have edge case here if smallest num is on the leftside and the largest on the right side the these overlap when we swap them
    //3,4,5,5,3,1 when we swap 1 with 3 and later with 5 5 index is now at n-1 th position so we will be doing one swap less in this use case

    if (smallIdx > largeIdx) {
      return res - 1;
    }
    return res;

  }

  @Test
  public void test() {
    int[] nums = {36, 19, 30, 19, 19};
    System.out.println(minimumSwaps(nums));
  }

}
