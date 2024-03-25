package interview.graph;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class CountSubIslands_1905 {


  public int countSubIslands(int[][] grid1, int[][] grid2) {

    int count = 0;

    for (int i = 0; i < grid1.length; i++) {
      for (int j = 0; j < grid1[0].length; j++) {
        if (grid2[i][j] == 1) {
          if (helper(i, j, grid1, grid2)) {
            count++;
          }
        }
      }
    }

    return count;

  }

  private boolean helper(int row, int col, int[][] grid1, int[][] grid2) {
    if (row < 0 || row >= grid1.length || col < 0 || col >= grid1[0].length
        || grid2[row][col] == 0) {
      return true;
    }

    if (grid1[row][col] == 0 && grid2[row][col] == 1) {
      return false;
    }
    grid2[row][col] = 0;

    boolean left = helper(row - 1, col, grid1, grid2);
    boolean right = helper(row + 1, col, grid1, grid2);
    boolean up = helper(row, col - 1, grid1, grid2);
    boolean down = helper(row, col + 1, grid1, grid2);

    return left && right && up && down;
  }


  @Test
  public void test() {
    int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0},
        {1, 1, 0, 1, 1}};
    int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0},
        {0, 1, 0, 1, 0}};
    countSubIslands(grid1, grid2);
  }

  @Test
  public void test2() {
    int[][] grid1 = {{1, 1, 1, 1, 0, 0}, {1, 1, 0, 1, 0, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 0, 0, 1},
        {1, 1, 1, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 1, 1},
        {1, 0, 0, 0, 1, 0}, {1, 1, 1, 1, 1, 0}};
    int[][] grid2 = {{1, 1, 1, 1, 0, 1}, {0, 0, 1, 0, 1, 0}, {1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1},
        {1, 1, 1, 0, 1, 0}, {0, 1, 1, 1, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 0, 1},
        {1, 1, 1, 1, 1, 1}, {1, 0, 0, 1, 0, 0}};
    countSubIslands(grid1, grid2);
  }

}
