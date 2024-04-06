package interview.graph;

import org.junit.Test;

public class MaxAreaofIsland {

  public int maxAreaOfIsland(int[][] grid) {

    int maxArea = 0;

    int m = grid.length;
    int n = grid[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          maxArea = Math.max(maxArea, dfs(i, j, m, n, grid));
        }
      }
    }
    return maxArea;
  }

  private int dfs(int row, int col, int totalRows, int totalCols,
      int[][] grid) {
    if (row < 0 || row >= totalRows || col < 0 || col >= totalCols || grid[row][col] != 1) {
      return 0;
    }

    grid[row][col] = 0;

    int up = dfs(row - 1, col, totalRows, totalCols, grid);
    int down = dfs(row + 1, col, totalRows, totalCols, grid);
    int left = dfs(row, col - 1, totalRows, totalCols, grid);
    int right = dfs(row, col + 1, totalRows, totalCols, grid);

    return 1 + left + right + up + down;
  }


  @Test
  public void test1() {
    int[][] grid = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
    System.out.println(maxAreaOfIsland(grid));
  }

}


