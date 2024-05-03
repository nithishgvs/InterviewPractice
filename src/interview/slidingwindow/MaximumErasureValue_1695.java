package interview.slidingwindow;

import java.util.*;

public class MaximumErasureValue_1695 {


  public int maximumUniqueSubarray(int[] nums) {
    int currSum = nums[0];

    int max = currSum;

    int left = 0;
    int right = 1;

    Set<Integer> set = new HashSet<>();

    set.add(nums[0]);

    while (right < nums.length) {

      int current = nums[right];

      while (set.contains(current)) {
        currSum -= nums[left];
        set.remove(nums[left]);
        left++;
      }

      set.add(current);
      currSum += current;
      max = Math.max(max, currSum);
      right++;
    }

    return max;
  }
}
