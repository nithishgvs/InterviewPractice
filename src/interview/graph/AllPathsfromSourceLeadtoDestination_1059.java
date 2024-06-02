package interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;

public class AllPathsfromSourceLeadtoDestination_1059 {

  public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

    int[] indegree = new int[n];

    Map<Integer, Set<Integer>> map = new HashMap<>();

    for (int[] edge : edges) {
      int src = edge[0];
      int dst = edge[1];
      indegree[dst]++;
      map.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
    }
    Queue<Integer> queue = new LinkedList<>();
    final boolean[] visiting = new boolean[n];

    queue.add(source);
    visiting[source] = true;

    while (!queue.isEmpty()) {
      Integer current = queue.poll();
      visiting[current] = false;
      if (map.getOrDefault(current, new HashSet<>()).size() == 0 && current != destination) {
        return false;
      }
      for (Integer next : map.getOrDefault(current, new HashSet<>())) {
        if (indegree[next] < 0) {
          return false;
        }
        if (visiting[next]) {
          continue;
        }

        queue.offer(next);
        indegree[next]--;
        visiting[next] = true;
      }
    }

    return true;

  }

  @Test
  public void test() {
    int[][] edges = {{0, 1}, {0, 2}};
    System.out.println(leadsToDestination(3, edges, 0, 2));
  }

}
