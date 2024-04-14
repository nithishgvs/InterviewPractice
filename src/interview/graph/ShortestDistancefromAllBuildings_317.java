package interview.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.Test;

public class ShortestDistancefromAllBuildings_317 {


  public int shortestDistance(int[][] grid) {

    //https://www.youtube.com/watch?v=yjHXS2w_IvY
    int shortestDistance = Integer.MAX_VALUE;

    int m = grid.length;
    int n = grid[0].length;

    int[][] distGrid = new int[m][n];

    //Building -> 1 Obstacle->2 Empty Land->0

    //BFS in 4 directions

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int emptyLand = 0;

    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (grid[row][col] == 1) {
          //Building Found we kick of BFS
          int localDistance = Integer.MAX_VALUE;
          Queue<int[]> queue = new ArrayDeque<>();
          queue.add(new int[]{row, col, 0});
          while (!queue.isEmpty()) {
            int[] popped = queue.poll();
            int currRow = popped[0];
            int currCol = popped[1];
            int currDistance = popped[2];

            for (int[] dirs : directions) {
              int newRow = currRow + dirs[0];
              int newCol = currCol + dirs[1];
              if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                continue;
              }
              //Empty land we decrement this value
              if (grid[newRow][newCol] == emptyLand) {
                grid[newRow][newCol] = grid[newRow][newCol] - 1;
                distGrid[newRow][newCol] += currDistance + 1;
                queue.add(new int[]{newRow, newCol, currDistance + 1});
                localDistance = Math.min(localDistance, distGrid[newRow][newCol]);
              }
            }
          }
          emptyLand = emptyLand - 1;
          shortestDistance = localDistance;
        }

      }
    }

    return shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
  }


  @Test

  public void test() {
    int[][] grid = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
    System.out.println(shortestDistance(grid));
  }


}
