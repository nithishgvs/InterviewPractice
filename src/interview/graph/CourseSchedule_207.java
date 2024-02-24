package interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.junit.Test;

public class CourseSchedule_207 {

  public boolean canFinish(int numCourses, int[][] prerequisites) {

    Map<Integer, List<Integer>> graph = new HashMap<>();

    int[] inDegree = new int[numCourses];
    for (int[] pre : prerequisites) {
      int from = pre[1];
      int to = pre[0];
      List<Integer> adjacencyList = graph.getOrDefault(from, new ArrayList<>());
      adjacencyList.add(to);
      graph.put(from, adjacencyList);
      inDegree[to]++;
    }

    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    List<Integer> topologicalSort = new ArrayList<>();

    while (!queue.isEmpty()) {
      int polled = queue.poll();
      topologicalSort.add(polled);

      for (int adj : graph.getOrDefault(polled, List.of())) {
        inDegree[adj]--;
        if (inDegree[adj] == 0) {
          queue.add(adj);
        }
      }
    }

    return topologicalSort.size() == numCourses;

  }


  @Test
  public void test() {
    System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
  }

}
