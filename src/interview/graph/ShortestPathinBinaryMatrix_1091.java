package interview.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathinBinaryMatrix_1091 {

  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
      return -1;
    }

    Queue<int[]> queue = new ArrayDeque<>();

    boolean[][] visited = new boolean[grid.length][grid[0].length];

    queue.add(new int[]{0, 0, 0});
    int[][] neighbours = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    while (!queue.isEmpty()) {
      int[] popped = queue.poll();
      int row = popped[0];
      int col = popped[1];
      int dist = popped[2];
      if (row == grid.length - 1 && col == grid[0].length - 1) {
        return dist + 1;
      }
      if (!visited[row][col]) {
        visited[row][col] = true;
        for (int[] neigh : neighbours) {
          int newRow = row + neigh[0];
          int newCol = col + neigh[1];
          if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != 0) {
            continue;
          }
          queue.add(new int[]{newRow, newCol, dist + 1});
        }
      }
    }

    return -1;
  }

}
