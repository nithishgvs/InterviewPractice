package interview.arrays;

import java.util.Arrays;

public class MinimumOperationstoReduceXtoZero_1658 {


  public int minOperations(int[] nums, int x) {
    //Concept is reverse of the target x we wanted
    //We deduct x from total sum-x and we find max window for the new target
    //Total length- max window gives the needed answer
    int sum = Arrays.stream(nums).sum();
    int target = sum - x;

    if (target < 0) {
      return -1;
    }

    int start = 0;
    int startIndex = 0;
    int maxWindowLength = -1;

    sum = 0;

    while (start <= nums.length - 1) {
      sum += nums[start];

      while (sum > target) {
        sum = sum - nums[startIndex];
        startIndex++;
      }

      if (sum == target) {
        maxWindowLength = Math.max(maxWindowLength, start - startIndex + 1);
      }
      start++;
    }

    return maxWindowLength == -1 ? -1 : nums.length - maxWindowLength;
  }

}
