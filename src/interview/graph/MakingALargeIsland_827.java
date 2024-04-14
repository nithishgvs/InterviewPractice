package interview.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class MakingALargeIsland_827 {


  public int largestIsland(int[][] grid) {
    //https://www.youtube.com/watch?v=FPTvylRPyFQ
    int maxIsland = 0;

    //We do this 2 iterations
    //First iteration concept
    //Go through entire array with DFS if you encounter island start a number like -1 and insert the size of it in a map
    // -1 , -2 and so on

    //In second iteration if you encounter 0 see if the neighbours have a number if yes get the value of this island from the hashmap we constructed and all it

    Map<Integer, Integer> islandsMap = new HashMap<>();
    int start = -1;
    int m = grid.length;
    int n = grid[0].length;

    boolean[][] visited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          int islandSize = dfs(i, j, m, n, start, grid, visited);
          islandsMap.put(start, islandSize);
          maxIsland = Math.max(islandSize, maxIsland);
          --start;
        }
      }
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) {
          int maxArea = 1;
          Set<Integer> seen = new HashSet<>();
          for (int[] neigh : directions) {
            int newRow = i + neigh[0];
            int newCol = j + neigh[1];
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n
                || grid[newRow][newCol] == 0) {
              continue;
            }
            if (!seen.contains(grid[newRow][newCol])) {
              maxArea += islandsMap.get(grid[newRow][newCol]);
              seen.add(grid[newRow][newCol]);
            }
          }
          maxIsland = Math.max(maxArea, maxIsland);
        }
      }
    }

    return maxIsland;
  }

  private int dfs(int row, int col, int m, int n, int start, int[][] grid, boolean[][] visited) {
    if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) {
      return 0;
    }
    grid[row][col] = start;
    visited[row][col] = true;
    int up = dfs(row - 1, col, m, n, start, grid, visited);
    int down = dfs(row + 1, col, m, n, start, grid, visited);
    int left = dfs(row, col - 1, m, n, start, grid, visited);
    int right = dfs(row, col + 1, m, n, start, grid, visited);

    return 1 + up + down + left + right;
  }

  @Test
  public void test() {
    int[][] grid = {{0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 0, 0},
        {1, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 0, 0}, {0, 1, 1, 1, 1, 0, 0}};
    System.out.println(largestIsland(grid));
  }
}
