package interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class MinimumTimetoCollectAllApplesinaTree_1443 {


  public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

    boolean hasToStart = false;

    for (Boolean has : hasApple) {
      if (has) {
        hasToStart = true;
        break;
      }
    }

    if (!hasToStart) {
      return 0;
    }

    Map<Integer, List<Integer>> map = new HashMap<>();

    for (int[] edge : edges) {
      if (!map.containsKey(edge[0])) {
        map.put(edge[0], new ArrayList<>());
      }

      if (!map.containsKey(edge[1])) {
        map.put(edge[1], new ArrayList<>());
      }

      map.get(edge[0]).add(edge[1]);
      map.get(edge[1]).add(edge[0]);
    }

    boolean[] visited = new boolean[n];

    return dfs(0, map, hasApple, visited);

  }

  private int dfs(int currVertex, Map<Integer, List<Integer>> map, List<Boolean> hasApple,
      boolean[] visited) {

    int count = 0;

    visited[currVertex] = true;
    for (Integer entries : map.getOrDefault(currVertex, new ArrayList<>())) {
      if (!visited[entries]) {
        int res = dfs(entries, map, hasApple, visited);
        if (res > 0 || hasApple.get(entries)) {
          count += (res + 2);
        }
      }
    }

    return count;
  }


  @Test
  public void test() {
    int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
    List<Boolean> hasApples = Arrays.asList(false, false, true, false, true, true, false);
    System.out.println(minTime(7, edges, hasApples));
  }

  @Test
  public void test1() {
    int[][] edges = {};
    List<Boolean> hasApples = Arrays.asList(true);
    System.out.println(minTime(1, edges, hasApples));
  }

}
