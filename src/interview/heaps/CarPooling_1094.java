package interview.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import org.junit.Test;

public class CarPooling_1094 {

  public boolean carPooling(int[][] trips, int capacity) {

    Arrays.sort(trips, (a, b) -> a[1] - b[1]);

    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

    for (int i = 0; i < trips.length; i++) {

      while (!minHeap.isEmpty() && minHeap.peek()[2] <= trips[i][1]) {
        capacity += minHeap.poll()[0];
      }
      minHeap.add(trips[i]);
      capacity -= trips[i][0];
      if (capacity < 0) {
        return false;
      }
    }
    return true;
  }


  @Test
  public void test() {
    int[][] trips = {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
    System.out.println(carPooling(trips, 11));
  }


  @Test
  public void test1() {
    int[][] trips = {{3, 2, 8}, {4, 4, 6}, {10, 8, 9}};
    System.out.println(carPooling(trips, 11));
  }

}
