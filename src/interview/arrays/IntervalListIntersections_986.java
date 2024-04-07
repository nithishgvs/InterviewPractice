package interview.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.Test;

public class IntervalListIntersections_986 {

  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

    if (firstList.length == 0 || secondList.length == 0) {
      return new int[0][0];
    }

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      }
      return a[0] - b[0];
    });

    for (int[] first : firstList) {
      priorityQueue.add(first);
    }

    for (int[] second : secondList) {
      priorityQueue.add(second);
    }

    int entry = priorityQueue.poll()[1];
    List<int[]> list = new ArrayList<>();
    while (!priorityQueue.isEmpty()) {
      int[] polled = priorityQueue.poll();
      if (polled[0] <= entry) {
        list.add(new int[]{polled[0], Math.min(entry, polled[1])});
      }
      entry = Math.max(entry, polled[1]);
    }

    return list.stream().toArray(int[][]::new);
  }


  @Test
  public void test() {
    int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
    int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
    intervalIntersection(firstList, secondList);
  }

}
