package interview.graph;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands_694 {

  public int numDistinctIslands(int[][] grid) {
    Set<String> routes = new HashSet<>();

    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          String shape = dfsHelper(visited, i, j, grid, "S");
          if (!routes.contains(shape)) {
            routes.add(shape);
          }
        }
      }
    }

    return routes.size();
  }

  private String dfsHelper(boolean[][] visited, int row, int col, int[][] grid, String direction) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]
        || grid[row][col] == 0) {
      return "X";
    }
    visited[row][col] = true;
    String left = dfsHelper(visited, row, col - 1, grid, "L");
    String right = dfsHelper(visited, row, col + 1, grid, "R");
    String up = dfsHelper(visited, row - 1, col, grid, "U");
    String down = dfsHelper(visited, row + 1, col, grid, "D");
    return direction + left + right + up + down;
  }
}
