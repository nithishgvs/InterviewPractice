package interview.graph;

import java.util.Arrays;

public class LongestIncreasingPathinaMatrix_329 {

  int maxPath = 0;

  public int longestIncreasingPath(int[][] matrix) {

    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    int[][] dp = new int[matrix.length][matrix[0].length];
    for (int[] arr : dp) {
      Arrays.fill(arr, -1);
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        int currentValue = 1 + dfs(matrix, i, j, visited, dp);
        maxPath = Math.max(currentValue, maxPath);
      }
    }
    return maxPath;
  }

  private int dfs(int[][] matrix, int row, int col, boolean[][] visited, int[][] dp) {

    if (visited[row][col]) {
      return 0;
    }
    if (dp[row][col] != -1) {
      return dp[row][col];
    }
    visited[row][col] = true;
    int up = 0, down = 0, left = 0, right = 0;
    if (row - 1 > -1 && matrix[row - 1][col] > matrix[row][col]) {
      up = 1 + dfs(matrix, row - 1, col, visited, dp);
    }
    if (row + 1 < matrix.length && matrix[row + 1][col] > matrix[row][col]) {
      down = 1 + dfs(matrix, row + 1, col, visited, dp);
    }
    if (col - 1 > -1 && matrix[row][col - 1] > matrix[row][col]) {
      left = 1 + dfs(matrix, row, col - 1, visited, dp);
    }
    if (col + 1 < matrix[0].length && matrix[row][col + 1] > matrix[row][col]) {
      right = 1 + dfs(matrix, row, col + 1, visited, dp);
    }
    visited[row][col] = false;
    dp[row][col] = Math.max(up, Math.max(down, Math.max(left, right)));
    return dp[row][col];
  }


}
