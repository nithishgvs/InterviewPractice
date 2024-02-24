package interview.graph;

import org.junit.Test;

public class MaxAreaOfIsland_695 {


  public int maxAreaOfIsland(int[][] grid) {

    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int maxArea = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          maxArea = Math.max(maxArea,  dfsHelper(i, j, grid, visited));
        }
      }
    }

    return maxArea;
  }

  private int dfsHelper(int row, int col, int[][] grid, boolean[][] visited) {

    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]
        || grid[row][col] == 0) {
      return 0;
    }
    visited[row][col] = true;
    int one = dfsHelper(row, col - 1, grid, visited);
    int two = dfsHelper(row, col + 1, grid, visited);
    int three = dfsHelper(row - 1, col, grid, visited);
    int four = dfsHelper(row + 1, col, grid, visited);

    return 1 + one + two + three + four;
  }

  @Test
  public void test() {
    int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

    System.out.println(maxAreaOfIsland(grid));
  }

}
