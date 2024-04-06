package interview.graph;

import org.junit.Test;

public class NumberofIslands {


  public int numIslands(char[][] grid) {

    int total = 0;

    int m = grid.length;
    int n = grid[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          dfs(i, j, m, n, grid);
          total++;
        }
      }
    }

    return total;
  }

  private void dfs(int row, int col, int totalRows, int totalCols, char[][] grid) {

    if (row < 0 || row >= totalRows || col < 0 || col >= totalCols || grid[row][col] != '1') {
      return;
    }
    grid[row][col] = '0';
    dfs(row + 1, col, totalRows, totalCols, grid);
    dfs(row - 1, col, totalRows, totalCols, grid);
    dfs(row, col + 1, totalRows, totalCols, grid);
    dfs(row, col - 1, totalRows, totalCols, grid);
  }

  @Test
  public void test() {
    char[][] grid = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
    };
    System.out.println(numIslands(grid));
  }

}
