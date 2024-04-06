package interview.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.Test;

public class ShortestBridge_943 {


  public int shortestBridge(int[][] grid) {

    int shortest = 0;

    //First visit all the 1's in the first island and keep them in a queue
    //Now start BFS from the each entry and expand putting 1's
    //As you encounter a new 1 it means you are connected to the second island
    //https://www.youtube.com/watch?v=THON9BpJXGQ
    Queue<int[]> queue = new ArrayDeque<>();
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];

    boolean dfsCalled = false;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          dfs(i, j, m, n, grid, visited, queue);
          dfsCalled = true;
          break;
        }
      }
      if (dfsCalled) {
        break;
      }
    }

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        int[] popped = queue.poll();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] neigh : directions) {
          int newRow = popped[0] + neigh[0];
          int newCol = popped[1] + neigh[1];
          if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
            continue;
          }
          if (!visited[newRow][newCol]) {
            if (grid[newRow][newCol] == 1) {
              return shortest;
            } else {
              grid[newRow][newCol] = 1;
              visited[newRow][newCol] = true;
              queue.add(new int[]{newRow, newCol});
            }
          }
        }
      }
      shortest++;
    }

    return shortest;

  }

  private void dfs(int row, int col, int totalRows, int totalCols, int[][] grid,
      boolean[][] visited, Queue<int[]> queue) {

    if (row < 0 || row >= totalRows || col < 0 || col >= totalCols || grid[row][col] != 1
        || visited[row][col]) {
      return;
    }
    visited[row][col] = true;
    queue.add(new int[]{row, col});
    dfs(row + 1, col, totalRows, totalCols, grid, visited, queue);
    dfs(row - 1, col, totalRows, totalCols, grid, visited, queue);
    dfs(row, col + 1, totalRows, totalCols, grid, visited, queue);
    dfs(row, col - 1, totalRows, totalCols, grid, visited, queue);
  }


  @Test
  public void test() {
    int[][] grid = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
    System.out.println(shortestBridge(grid));
  }

}
