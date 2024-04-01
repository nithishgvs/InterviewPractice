package interview.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class CountNodesWiththeHighestScore_2049 {


  public int countHighestScoreNodes(int[] parents) {

    Map<Integer, List<Integer>> graph = new HashMap<>();

    for (int i = 0; i < parents.length; i++) {
      if (parents[i] == -1) {
        continue;
      }
      if (!graph.containsKey(parents[i])) {
        graph.put(parents[i], new ArrayList<>());
      }
      graph.get(parents[i]).add(i);
    }
    long[] result = new long[parents.length];
    dfs(result, graph, 0);
    long maxValue = Arrays.stream(result).max().getAsLong();
    return (int) Arrays.stream(result).filter(r -> r == maxValue).count();
  }

  private long dfs(long[] result, Map<Integer, List<Integer>> graph, int source) {

    long product = 1, sum = 1;

    if (graph.containsKey(source)) {
      for (Integer child : graph.get(source)) {
        long childValue = dfs(result, graph, child);
        product *= childValue;
        sum += childValue;
      }
    }

    result[source] = product * (Math.max(1, result.length - (int) sum));
    return sum;
  }


  @Test
  public void test() {
    int[] parents = {-1, 2, 0, 2, 0};
    countHighestScoreNodes(parents);
  }

}
