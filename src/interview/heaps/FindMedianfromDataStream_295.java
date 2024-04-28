package interview.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianfromDataStream_295 {

  class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
      minHeap = new PriorityQueue<>();
      maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
      maxHeap.add(num);

      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.add(maxHeap.poll());
      }

      while (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
        maxHeap.add(minHeap.poll());
        minHeap.add(maxHeap.poll());
      }
    }

    public double findMedian() {
      if (minHeap.size() == maxHeap.size()) {
        return (double) (minHeap.peek() + maxHeap.peek()) / 2;
      } else {
        return maxHeap.peek();
      }
    }

  }

  public static void main(String[] args) {
    FindMedianfromDataStream_295 median = new FindMedianfromDataStream_295();
    MedianFinder medianFinder = median.new MedianFinder();
    medianFinder.addNum(-1);    // arr = [1]
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(-2);    // arr = [1, 2]
    System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
    medianFinder.addNum(-3);    // arr[1, 2, 3]
    System.out.println(medianFinder.findMedian()); // return 2.0
    medianFinder.addNum(-4);    // arr[1, 2, 3]
    System.out.println(medianFinder.findMedian()); // return 2.0
    medianFinder.addNum(-5);    // arr[1, 2, 3]
    System.out.println(medianFinder.findMedian()); // return 2.0
  }

}
