package interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;

public class CourseScheduleII {

  public int[] findOrder(int numCourses, int[][] prerequisites) {

    List<Integer> tSort = new ArrayList<>();

    int[] indegree = new int[numCourses];

    Map<Integer, Set<Integer>> map = new HashMap<>();

    for (int i = 0; i < prerequisites.length; i++) {
      int next = prerequisites[i][0];
      int prereq = prerequisites[i][1];
      map.computeIfAbsent(prereq, k -> new HashSet<>());
      map.get(prereq).add(next);
      indegree[next]++;
    }

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      Integer poll = queue.poll();
      tSort.add(poll);
      for (Integer adj : map.getOrDefault(poll, new HashSet<>())) {
        indegree[adj]--;
        if (indegree[adj] == 0) {
          queue.add(adj);
        }
      }
    }

    return tSort.size() == numCourses ? tSort.stream().mapToInt(i -> i).toArray() : new int[0];

  }

  @Test
  public void test() {
    int[][] prerequisites = {{1, 0}};
    System.out.println(findOrder(2, prerequisites));
  }
}
