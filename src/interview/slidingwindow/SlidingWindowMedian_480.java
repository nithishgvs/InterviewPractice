package interview.slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class SlidingWindowMedian_480 {

  class MedianFinder {

   // https://algo.monster/liteproblems/480
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    Map<Integer, Integer> countMap = new HashMap<>(); // keeps track of the number of instances a number has been delayed for removal

    int windowSize;
    int maxHeapSize, minHeapSize;

    public MedianFinder(int k) {
      this.windowSize = k;
    }


    public void addNum(int num) {
      // Add the number to the appropriate heap
      if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
        maxHeap.offer(num);
        maxHeapSize++;
      } else {
        minHeap.offer(num);
        minHeapSize++;
      }
      rebalanceHeaps(); // Ensure both heaps remain in a valid state
    }


    private void rebalanceHeaps() {
      // Maintain the property that maxHeap has the same number of elements as minHeap, or 1 more
      if (maxHeapSize > minHeapSize + 1) {
        minHeap.offer(maxHeap.poll());
        maxHeapSize--;
        minHeapSize++;
        pruneHeap(maxHeap); // Ensure maxHeap is pruned
      } else if (maxHeapSize < minHeapSize) {
        maxHeap.offer(minHeap.poll());
        minHeapSize--;
        maxHeapSize++;
        pruneHeap(minHeap); // Ensure minHeap is pruned
      }
    }

    private void pruneHeap(PriorityQueue<Integer> heap) {
      // Remove elements from the heap that were marked for delayed removal
      while (!heap.isEmpty() && countMap.containsKey(heap.peek())) {
        int heapTop = heap.peek();
        countMap.put(heapTop, countMap.get(heapTop) - 1);
        if (countMap.get(heapTop) == 0) {
          countMap.remove(heapTop); // remove the entry from the map if the count goes to zero
        }
        heap.poll(); // remove the top element in the heap as it's already accounted for in the delayed removal
      }
    }

    public void removeNum(int num) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1); // Mark the number for delayed removal
      if (num <= maxHeap.peek()) {
        maxHeapSize--;
        if (num == maxHeap.peek()) {
          pruneHeap(maxHeap); // Remove elements that should be delayed from the maxHeap
        }
      } else {
        minHeapSize--;
        if (num == minHeap.peek()) {
          pruneHeap(minHeap); // Remove elements that should be delayed from the minHeap
        }
      }
      rebalanceHeaps(); // Ensure both heaps remain in a valid state
    }

    public double findMedian() {
      // If odd window size, the median is the top of the max heap, otherwise, the median is the average of the tops of both heaps
      return (windowSize & 1) == 1 ? maxHeap.peek()
          : ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
    }

  }


  public double[] medianSlidingWindow(int[] nums, int k) {

    MedianFinder finder = new MedianFinder(k);
    // Populate the MedianFinder with the initial sliding window
    for (int i = 0; i < k; ++i) {
      finder.addNum(nums[i]);
    }

    int n = nums.length;
    double[] medians = new double[n - k + 1]; // Array to hold the medians
    medians[0] = finder.findMedian(); // Find the median for the first window

    // Move the sliding window and calculate the median for each window
    for (int i = k; i < n; ++i) {
      finder.addNum(nums[i]); // Add the new element to the sliding window
      finder.removeNum(nums[i - k]); // Remove the oldest element from the sliding window
      medians[i - k + 1] = finder.findMedian(); // Find the median for the current window
    }
    return medians; // Return the array of medians
  }

  @Test
  public void test() {
    int[] nums = {2147483647, 2147483647};
    int[] nums2 = {1, 3, -1, -3, 5, 3, 6, 7};
    medianSlidingWindow(nums2, 3);
  }
}
