package interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class MaximumPathQualityofaGraph_2065 {

  int maxPathQuality = 0;

  public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {

    Map<Integer, List<int[]>> graph = new HashMap<>();

    for (int[] edge : edges) {
      if (!graph.containsKey(edge[0])) {
        graph.put(edge[0], new ArrayList<>());
      }
      if (!graph.containsKey(edge[1])) {
        graph.put(edge[1], new ArrayList<>());
      }
      //Undirected graph so the edge will go both ways src->dst & dst->src
      graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
      graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
    }

    //There are at most four edges connected to each node
    //10 <= time[j], maxTime <= 100 By this constraint, there are at most 10 nodes in a path.
    //Based on the aforementioned constraints, the brute force approach runs in O(4^10) = O(2^20)
    int[] visited = new int[values.length];

    dfs(0, 0, 0, graph, visited, maxTime, values);
    return maxPathQuality;
  }

  private void dfs(int source, int currentTime, int currentQuality, Map<Integer, List<int[]>> graph,
      int[] visited, int maxTime, int[] values) {
    if (currentTime > maxTime) {
      return;
    }
    if (visited[source] == 0) {
      currentQuality += values[source];
    }
    if (source == 0) {
      maxPathQuality = Math.max(maxPathQuality, currentQuality);
    }

    visited[source]++;
    List<int[]> adjacentVertices = graph.getOrDefault(source, new ArrayList<>());

    if (!adjacentVertices.isEmpty()) {
      for (int[] adjacentVertex : adjacentVertices) {
        dfs(adjacentVertex[0], currentTime + adjacentVertex[1], currentQuality, graph, visited,
            maxTime, values);
      }
    }
    visited[source]--;

  }

  @Test
  public void test() {
    int[] values = {0, 32, 10, 43};
    int[][] edges = {{0, 1, 10}, {1, 2, 15}, {0, 3, 10}};
    maximalPathQuality(values, edges, 49);
  }

  @Test
  public void test2() {
    int[] values = {1, 2, 3, 4};
    int[][] edges = {{0, 1, 10}, {1, 2, 11}, {2, 3, 12}, {1, 3, 13}};
    int max = maximalPathQuality(values, edges, 50);
    System.out.println(max);
  }

  @Test
  public void test3() {
    int[] values = {0, 1, 2};
    int[][] edges = {{1, 2, 10}};
    int max = maximalPathQuality(values, edges, 10);
    System.out.println(max);
  }
}

