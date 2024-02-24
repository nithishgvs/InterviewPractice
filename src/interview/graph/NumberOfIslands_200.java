package interview.graph;

import org.junit.Test;

public class NumberOfIslands_200 {


  public int numIslands(char[][] grid) {

    int islands = 0;

    boolean[][] visited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          islands++;
          dfsHelper(i, j, grid, visited);
        }
      }
    }

    return islands;

  }

  private void dfsHelper(int row, int col, char[][] grid, boolean[][] visited) {

    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]
        || grid[row][col] == '0') {
      return;
    }
    visited[row][col] = true;
    dfsHelper(row, col - 1, grid, visited);
    dfsHelper(row, col + 1, grid, visited);
    dfsHelper(row - 1, col, grid, visited);
    dfsHelper(row + 1, col, grid, visited);
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

  @Test
  public void tes2() {
    char[][] grid = {
        {'1'},
        {'1'}
    };
    System.out.println(numIslands(grid));
  }
}
