package interview.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements_658 {

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> list = new ArrayList<>();

    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> {
      if (Math.abs(a - x) == Math.abs(b - x)) {
        return a - b;
      }
      return Math.abs(a - x) - Math.abs(b - x);
    });

    for (int i = 0; i < arr.length; i++) {
      minHeap.add(arr[i]);
    }

    while (k > 0) {
      list.add(minHeap.poll());
      k--;
    }

    Collections.sort(list);
    return list;
  }

}
