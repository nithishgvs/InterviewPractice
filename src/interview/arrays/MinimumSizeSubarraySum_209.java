package interview.arrays;

import java.util.Arrays;

public class MinimumSizeSubarraySum_209 {

  public int minSubArrayLen(int target, int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum < target) {
      return 0;
    }

    int minLength = Integer.MAX_VALUE;

    sum = 0;

    int start = 0;
    int startIndex = 0;

    while (start < nums.length) {
      sum += nums[start];

      while (sum >= target) {
        minLength = Math.min(start - startIndex + 1, minLength);
        sum -= nums[startIndex];
        startIndex++;
      }

      start++;

    }

    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }

}
