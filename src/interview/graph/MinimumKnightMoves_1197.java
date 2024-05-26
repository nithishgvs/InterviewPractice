package interview.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import javafx.util.Pair;
import org.junit.Test;

public class MinimumKnightMoves_1197 {

  public int minKnightMoves(int x, int y) {
    if (x == 0 && y == 0) {
      return 0;
    }

    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    int dist = 0;
    int[][] directions = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

    Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
    queue.add(new Pair<>(0, 0));
    visited.add(new Pair<>(0, 0));

    x = Math.abs(x);
    y = Math.abs(y);

    while (!queue.isEmpty()) {
      int size = queue.size();
      dist++;
      while (size-- != 0) {
        Pair<Integer, Integer> polled = queue.poll();
        for (int[] dir : directions) {
          int newX = Math.abs(polled.getKey() + dir[0]);
          int newY = Math.abs(polled.getValue() + dir[1]);
          if (newX == x && newY == y) {
            return dist;
          }
          Pair<Integer, Integer> pair = new Pair<>(newX, newY);
          if (!visited.contains(pair) && newX >= 0 && newY >= 0) {
            queue.add(pair);
            visited.add(pair);
          }
        }
      }

    }

    return -1;
  }

  @Test
  public void test() {
    System.out.println(minKnightMoves(5, 5));
  }


}
