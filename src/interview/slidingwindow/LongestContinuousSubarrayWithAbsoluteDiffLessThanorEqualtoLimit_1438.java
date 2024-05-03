package interview.slidingwindow;

import java.util.*;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit_1438 {


  public int longestSubarray(int[] nums, int limit) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    int left = 0, right = 0;

    int res = 1;

    while (right < nums.length) {
      minHeap.add(nums[right]);
      maxHeap.add(nums[right]);

      while (Math.abs(maxHeap.peek() - minHeap.peek()) > limit) {
        minHeap.remove(nums[left]);
        maxHeap.remove(nums[left]);
        left++;
      }

      res = Math.max(right - left + 1, res);
      right++;
    }

    return res;
  }
}
