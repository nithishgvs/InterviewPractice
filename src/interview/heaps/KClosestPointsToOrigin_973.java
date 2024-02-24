package interview.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import org.junit.Test;

public class KClosestPointsToOrigin_973 {

  public int[][] kClosest(int[][] points, int k) {

    int[][] result = new int[k][2];

    Map<int[], Double> map = Arrays.stream(points)
        .collect(Collectors.toMap(
            point -> point,
            point -> Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2))
        ));

    PriorityQueue<Map.Entry<int[], Double>> minHeap = new PriorityQueue<>(
        Comparator.comparing(Map.Entry::getValue));

    minHeap.addAll(map.entrySet());

    int i = 0;

    while (k > 0) {
      result[i] = minHeap.poll().getKey();
      k--;
      i++;
    }

    return result;

  }

  @Test
  public void test() {
    int[][] points = {{1, 3}, {-2, 2}};
    kClosest(points, 1);
  }

}
