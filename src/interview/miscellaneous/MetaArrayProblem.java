package interview.miscellaneous;

import java.util.Arrays;

public class MetaArrayProblem {

  /**
   * given an array of positive numbers and N, return true if you can cut the array into N
   * contiguous subarrays such that the sum of each subarray is equal. example_1 = v = [1,2,3,6], N
   * = 2 should return True since v1 = [1,2,3] v2 = [6] example_2 = v = [1,2,3,6] N = 4 False
   */


  public boolean cutPossible(int[] nums, int k) {

    int sum = Arrays.stream(nums).sum();

    if (sum % k != 0) {
      return false;
    }

    int currSum = 0;
    int targetSum = sum / k;
    for (int i = 0; i < nums.length; i++) {
      currSum += nums[i];
      if (currSum > targetSum) {
        return false;
      }
      if (currSum == targetSum) {
        currSum = 0;
      }
    }

    return currSum == 0;
  }

}
