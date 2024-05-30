package interview.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

public class MetaIslandProblem {

  /**
   * Given an island surrounded with water, island is made up of MxN matrix. Each cell of the island
   * is of certain height from the water level. if a cell is flooded with water, you can not travel
   * to that cell. Goal is to minimize the maximum rise in water level which will disconnect the
   * path (there should not be any possible path) from top left cell to bottom right cell.
   */
  public static int minMaxRiseToDisconnect(int[][] matrix) {
    int M = matrix.length;
    int N = matrix[0].length;

    // Find the minimum and maximum heights in the matrix
    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        low = Math.min(low, matrix[i][j]);
        high = Math.max(high, matrix[i][j]);
      }
    }

    // Binary search on water level
    while (low < high) {
      int mid = (low + high) / 2;
      if (canTravel(matrix, mid, M, N)) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }

  private static boolean canTravel(int[][] matrix, int waterLevel, int M, int N) {
    if (matrix[0][0] <= waterLevel) {
      return false;
    }

    boolean[][] visited = new boolean[M][N];
    int[] directions = {-1, 0, 1, 0, -1};
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];

      for (int i = 0; i < 4; i++) {
        int newX = x + directions[i];
        int newY = y + directions[i + 1];

        if (newX >= 0 && newX < M && newY >= 0 && newY < N && !visited[newX][newY]
            && matrix[newX][newY] > waterLevel) {
          if (newX == M - 1 && newY == N - 1) {
            return true;
          }
          queue.add(new int[]{newX, newY});
          visited[newX][newY] = true;
        }
      }
    }

    return visited[M - 1][N - 1];
  }

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 2, 3, 5},
        {3, 2, 3, 4, 4},
        {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}
    };

    System.out.println(minMaxRiseToDisconnect(
        matrix)); // Output the minimum water level rise that disconnects the island
  }
}
