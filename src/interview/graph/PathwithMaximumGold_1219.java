package interview.graph;

public class PathwithMaximumGold_1219 {



  int max = 0;
  public int getMaximumGold(int[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        helper(grid, i, j, grid.length, grid[0].length, visited);
      }
    }


    return max;
  }

  private int helper(int[][] grid, int row, int col, int m, int n, boolean[][] visited) {

    if (row >= m || row < 0 || col >= n || col < 0 || visited[row][col]) {
      return 0;
    }

    if (grid[row][col] == 0) {
      return 0;
    }

    visited[row][col] = true;
    int left = helper(grid, row - 1, col, m, n, visited);
    int right = helper(grid, row + 1, col, m, n, visited);
    int up = helper(grid, row, col - 1, m, n, visited);
    int down = helper(grid, row, col + 1, m, n, visited);
    int value = Math.max(right, Math.max(left, Math.max(up, down))) + grid[row][col];
    max = Math.max(value, max);
    visited[row][col] = false;
    return value;
  }
}
