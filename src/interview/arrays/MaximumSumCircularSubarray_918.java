package interview.arrays;

public class MaximumSumCircularSubarray_918 {


  public int maxSubarraySumCircular(int[] nums) {
    //https://www.youtube.com/watch?v=qZvCdrvCzXY
    //Find sum of array
    //Find maxSum
    //Find minSum by flipping the array numbers to negative
    //Retun Max(maxsum,sum-MinSum)
    int totalSum = 0;
    int max1 = kadane(nums);
    for (int i = 0; i < nums.length; i++) {
      totalSum += nums[i];
      nums[i] = -nums[i];
    }
    int min = kadane(nums);
    int max2 = totalSum + min;
    if (max2 == 0) {
      return max1;
    }
    return Math.max(max1, max2);
  }

  private int kadane(int[] array) {
    int macSum = array[0];
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      macSum = Math.max(macSum + array[i], array[i]);
      max = Math.max(max, macSum);
    }
    return max;
  }
}
