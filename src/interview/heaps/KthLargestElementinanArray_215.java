package interview.heaps;

import java.util.PriorityQueue;

public class KthLargestElementinanArray_215 {

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int num : nums) {
      minHeap.add(num);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    return minHeap.peek();
  }

}
