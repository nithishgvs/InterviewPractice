package interview.graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Test;

public class MinCosttoConnectAllPoints_1584 {


  public int minCostConnectPoints(int[][] points) {

    //Minimal Spanning tree
    //Randomly choosing a vertex and calculating distance from that vertex to other vertices
    //Initially we add vertex at 0th index (We can choose arbitrary vertex for MST) and cost 0 to the priority queue
    //We find distance with all vertices and choose the nearest vertex

    int minCost = 0;

    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

    int[] visited = new int[points.length];

    //Added point[0] as the starting point and 0 as distance
    minHeap.add(new int[]{0, 0});

    while (!minHeap.isEmpty()) {
      int[] polled = minHeap.poll();
      int index = polled[0];
      int distance = polled[1];
      if (visited[index] != 1) {
        visited[index] = 1;
        minCost += distance;
        for (int i = 0; i < points.length; i++) {
          if (i == index && visited[i] == 1) {
            continue;
          }
          minHeap.add(new int[]{i, Math.abs(points[index][0] - points[i][0]) + Math
              .abs(points[index][1] - points[i][1])});
        }
      }

    }

    return minCost;
  }

  @Test
  public void test() {
    int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
    System.out.println(minCostConnectPoints(points));
  }

}
