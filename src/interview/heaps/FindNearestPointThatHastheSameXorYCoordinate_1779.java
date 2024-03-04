package interview.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindNearestPointThatHastheSameXorYCoordinate_1779 {


  public int nearestValidPoint(int x, int y, int[][] points) {
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

    for (int i = 0; i < points.length; i++) {
      //Calculate Manhattan distance
      if (points[i][0] == x && points[i][1] == y) {
        return i;
      } else if (points[i][0] == x || points[i][1] == y) {
        int manhattanDist = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
        minHeap.add(new int[]{i, manhattanDist});
      }

    }

    if (!minHeap.isEmpty()) {
      return minHeap.peek()[0];
    }
    return -1;
  }
}
