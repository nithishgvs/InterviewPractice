package interview.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class HighFive_1086 {


  public int[][] highFive(int[][] items) {

    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    int[][] res;

    for (int i = 0; i < items.length; i++) {
      map.computeIfAbsent(items[i][0], k -> new PriorityQueue<>(Comparator.reverseOrder()));
      map.get(items[i][0]).add(items[i][1]);
    }

    res = new int[map.size()][2];

    int i = 0;

    for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {

      int k = 5;
      int sum = 0;

      while (k != 0 && !entry.getValue().isEmpty()) {
        sum += entry.getValue().poll();
        k--;
      }
      res[i][0] = entry.getKey();
      res[i][1] = sum/5;
      i++;

    }

    return res;
  }

  @Test
  public void test() {
    highFive(new int[][]{{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87},
        {1, 100}, {2, 100}, {2, 76}});
  }


}
