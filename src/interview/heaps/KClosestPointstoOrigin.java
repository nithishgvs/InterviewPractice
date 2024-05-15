package interview.heaps;

import java.util.PriorityQueue;
import org.junit.Test;

public class KClosestPointstoOrigin {

  public int[][] kClosest(int[][] points, int k) {

    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
      double dist1 = Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
      double dist2 = Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2));
      return Double.compare(dist2, dist1);
    });

    for (int[] p : points) {
      maxHeap.add(p);
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }

    int[][] res = new int[k][2];

    int idx = 0;

    while (idx < k) {
      res[idx][0] = maxHeap.peek()[0];
      res[idx][1] = maxHeap.poll()[1];
      idx++;
    }
    return res;

  }

  @Test
  public void test() {
    int[][] points = {{1, 3}, {-2, 2}};
    System.out.println(kClosest(points, 1));
  }

}
