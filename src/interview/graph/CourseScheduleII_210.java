package interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.junit.Test;

public class CourseScheduleII_210 {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<Integer> topologicalSort = new ArrayList<>();

    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] inDegree = new int[numCourses];

    for (int[] pre : prerequisites) {
      int from = pre[1];
      int to = pre[0];
      inDegree[to]++;
      List<Integer> adjacencyList = graph.getOrDefault(from, new ArrayList<>());
      adjacencyList.add(to);
      graph.put(from, adjacencyList);
    }

    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {

      Integer polled = queue.poll();
      topologicalSort.add(polled);

      for (int adj : graph.getOrDefault(polled, List.of())) {
        inDegree[adj]--;
        if (inDegree[adj] == 0) {
          queue.add(adj);
        }
      }

    }

    return topologicalSort.size() == numCourses ? topologicalSort.stream()
        .mapToInt(Integer::intValue).toArray() : new int[0];
  }

  @Test
  public void test() {
    System.out.println(findOrder(2, new int[][]{{1, 0}, {1, 2}, {0, 1}}));
  }
}
