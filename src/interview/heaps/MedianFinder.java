package interview.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

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
    while (minHeap.size() > 0 && minHeap.peek() < maxHeap.peek()) {
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

  public static void main(String[] args) {
    MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(1);
    medianFinder.addNum(2);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(3);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(4);
    medianFinder.addNum(5);
    medianFinder.addNum(6);
    System.out.println(medianFinder.findMedian());
  }
}
