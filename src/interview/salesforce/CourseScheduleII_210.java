package interview.salesforce;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.junit.Test;

public class CourseScheduleII_210 {

  public int[] findOrder(int numCourses, int[][] prerequisites) {

    int[] indegree = new int[numCourses];

    Map<Integer, List<Integer>> map = new HashMap<>();

    for (int[] pre : prerequisites) {
      if (!map.containsKey(pre[1])) {
        map.put(pre[1], new ArrayList<>());
      }
      map.get(pre[1]).add(pre[0]);
      indegree[pre[0]]++;
    }

    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < indegree.length; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    List<Integer> topSort = new ArrayList<>();

    while (!queue.isEmpty()) {
      int currVertex = queue.poll();
      topSort.add(currVertex);
      for (Integer adj : map.getOrDefault(currVertex, new ArrayList<>())) {

        indegree[adj]--;

        if (indegree[adj] == 0) {
          queue.add(adj);
        }
      }
    }

    return topSort.size() == numCourses ? topSort.stream().mapToInt(Integer::intValue).toArray()
        : new int[0];

  }

  @Test
  public void test() {
    int[][] pre = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    int[][] pre1 = {};
    findOrder(1, pre1);
  }

}
