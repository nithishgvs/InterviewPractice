package interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.junit.Test;

public class IsGraphBipartite_785 {


  public boolean isBipartite(int[][] graph) {

    int[] color = new int[graph.length];
    Arrays.fill(color, -1);

    Map<Integer, List<Integer>> graphMap = new HashMap<>();

    for (int i = 0; i < graph.length; i++) {
      List<Integer> adjacentList = graphMap.getOrDefault(i, new ArrayList<>());
      for (int adj : graph[i]) {
        adjacentList.add(adj);
      }
      graphMap.put(i, adjacentList);
    }

    for (Integer vertex : graphMap.keySet()) {
      if (color[vertex] == -1) {
        color[vertex] = 0;
        if (!isBipartiteHelper(vertex, graphMap, color)) {
          return false;
        }
      }

    }

    return true;

  }

  private boolean isBipartiteHelper(Integer vertex, Map<Integer, List<Integer>> graphMap,
      int[] color) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(vertex);
    while (!queue.isEmpty()) {
      Integer sourceVertex = queue.poll();
      List<Integer> adjacentList = graphMap.get(sourceVertex);
      for (Integer adj : adjacentList) {
        if (color[adj] == color[sourceVertex]) {
          return false;
        }
        if (color[adj] == -1) {
          color[adj] = 1 - color[sourceVertex];
          queue.add(adj);
        }

      }
    }
    return true;

  }

  @Test
  public void test() {
    int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
    int[][] graph2 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
    System.out.println(isBipartite(graph));
  }

}
