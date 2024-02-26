package interview.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import org.junit.Test;

public class NetworkDelayTime_743 {

  public int networkDelayTime(int[][] times, int n, int k) {

    Set<Integer> visited = new HashSet<>();

    Map<Integer, List<int[]>> graph = new HashMap<>();

    for (int[] neighbour : times) {
      int source = neighbour[0];
      int destination = neighbour[1];
      int time = neighbour[2];
      List<int[]> neigh = graph.getOrDefault(source, new ArrayList<>());
      neigh.add(new int[]{destination, time});
      graph.put(source, neigh);
    }

    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    minHeap.add(new int[]{k, 0});
    int delay = Integer.MAX_VALUE;
    while (!minHeap.isEmpty()) {
      int[] polled = minHeap.poll();
      if (!visited.contains(polled[0])) {
        visited.add(polled[0]);
        if (visited.size() == n) {
          delay = Math.min(delay, polled[1]);
        }
        List<int[]> neighbours = graph.getOrDefault(polled[0], new ArrayList<>());
        for (int[] neigh : neighbours) {
          minHeap.add(new int[]{neigh[0], polled[1] + neigh[1]});
        }
      }
    }

    return visited.size() == n ? delay : -1;

  }

  @Test
  public void test1() {
    int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
    System.out.println(networkDelayTime(times, 4, 2));
  }

  @Test
  public void test2() {
    int[][] times = {{1, 2, 1}};
    System.out.println(networkDelayTime(times, 2, 2));
  }

  @Test
  public void test3() {
    int[][] times = {{1, 0, 1}, {1, 2, 2}, {2, 3, 3}, {0, 3, 6}};
    System.out.println(networkDelayTime(times, 4, 1));
  }


}
