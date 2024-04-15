package interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import org.junit.Test;

public class ShortestPathinBinaryMatrix {


  public int shortestPathBinaryMatrix(int[][] grid) {

    int m = grid.length;
    int n = grid[0].length;
    if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
      return -1;
    }

    int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{0, 0, 1});

    while (!queue.isEmpty()) {
      int[] polled = queue.poll();
      int row = polled[0];
      int col = polled[1];
      int dist = polled[2];
      if (row == m - 1 && col == n - 1) {
        return dist;
      }

      for (int[] dir : directions) {
        int newRow = row + dir[0];
        int newCol = col + dir[1];
        if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] == 1) {
          continue;
        }
        grid[newRow][newCol] = 1;
        queue.add(new int[]{newRow, newCol, dist + 1});
      }
    }

    return -1;

  }

  class MatrixHelper {

    int row;
    int col;
    List<Integer> location;

    public MatrixHelper(int row, int col, List<Integer> location) {
      this.row = row;
      this.col = col;
      this.location = location;
    }
  }


  public List<List<Integer>> shortestPathBinaryMatrix2(int[][] grid) {

    int m = grid.length;
    int n = grid[0].length;
    List<List<Integer>> result = new ArrayList<>();
    if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
      return new ArrayList<>();
    }

    int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    Queue<MatrixHelper> queue = new ArrayDeque<>();
    queue.add(new MatrixHelper(0, 0, Arrays.asList(0, 0)));

    while (!queue.isEmpty()) {
      MatrixHelper polled = queue.poll();
      int row = polled.row;
      int col = polled.col;
      if (row == m - 1 && col == n - 1) {
        result.add(polled.location);
        return result;
      }
      for (int[] dir : directions) {
        int newRow = row + dir[0];
        int newCol = col + dir[1];
        if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] == 1) {
          continue;
        }
        result.add(polled.location);
        grid[newRow][newCol] = 1;
        queue.add(new MatrixHelper(newRow, newCol, Arrays.asList(newRow, newCol)));
      }
    }

    return new ArrayList<>();

  }

  @Test
  public void test() {
    int[][] grid = {{0, 1}, {1, 0}};
    //System.out.println(shortestPathBinaryMatrix(grid));
    System.out.println(shortestPathBinaryMatrix2(grid));
  }

}
