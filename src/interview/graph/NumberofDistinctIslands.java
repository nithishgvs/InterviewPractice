package interview.graph;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class NumberofDistinctIslands {


  public int numDistinctIslands(int[][] grid) {

    Set<String> visited = new HashSet<>();
    int m = grid.length;
    int n = grid[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          String path = dfs(i, j, m, n, "S", grid);
          if (!visited.contains(path)) {
            visited.add(path);
          }
        }
      }
    }

    return visited.size();

  }

  private String dfs(int row, int col, int totalRows, int totalCols, String direction,
      int[][] grid) {
    if (row < 0 || row >= totalRows || col < 0 || col >= totalCols || grid[row][col] != 1) {
      return "|";
    }

    grid[row][col] = 0;

    String up = dfs(row - 1, col, totalRows, totalCols, "U", grid);
    String down = dfs(row + 1, col, totalRows, totalCols, "D", grid);
    String left = dfs(row, col - 1, totalRows, totalCols, "L", grid);
    String right = dfs(row, col + 1, totalRows, totalCols, "R", grid);

    return direction + left + right + up + down;
  }

  @Test
  public void test1() {
    int[][] grid = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
    System.out.println(numDistinctIslands(grid));
  }

}
