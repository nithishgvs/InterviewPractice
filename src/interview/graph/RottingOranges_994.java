package interview.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.Test;

public class RottingOranges_994 {

  public int orangesRotting(int[][] grid) {

    int freshOranges = 0;
    int mins = 0;
    Queue<int[]> queue = new ArrayDeque<>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          freshOranges++;
        } else if (grid[i][j] == 2) {
          queue.add(new int[]{i, j});
        }
      }
    }

    while (!queue.isEmpty()) {
      if (freshOranges == 0) {
        return mins;
      }
      int size = queue.size();
      mins++;
      for (int i = 0; i < size; i++) {
        int[] polled = queue.poll();
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int[] direction : directions) {
          int newRow = polled[0] + direction[0];
          int newCol = polled[1] + direction[1];
          if (newRow > -1 && newRow < grid.length && newCol > -1 && newCol < grid[0].length
              && grid[newRow][newCol] == 1) {
            grid[newRow][newCol] = 2;
            freshOranges--;
            queue.add(new int[]{newRow, newCol});
          }
        }
      }
    }

    return freshOranges == 0 ? 0 : -1;
  }


  @Test
  public void test() {
    int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
    System.out.println(orangesRotting(grid));
  }

  @Test
  public void test2() {
    int[][] grid = {{0}};
    System.out.println(orangesRotting(grid));
  }

}
