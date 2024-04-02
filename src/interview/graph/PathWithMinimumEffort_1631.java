package interview.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Test;

public class PathWithMinimumEffort_1631 {

  public int minimumEffortPath(int[][] heights) {

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

    priorityQueue.add(new int[]{0, 0, 0});

    int[][] dp = new int[heights.length][heights[0].length];

    for (int[] arr : dp) {
      Arrays.fill(arr, Integer.MAX_VALUE);
    }

    dp[0][0] = 0;

    while (!priorityQueue.isEmpty()) {
      int[] current = priorityQueue.poll();

      int row = current[0];
      int col = current[1];
      int minPath = current[2];

      if (row == heights.length - 1 && col == heights[0].length - 1) {
        return minPath;
      }

      int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

      for (int[] direction : directions) {
        int newRow = row + direction[0];
        int newCol = col + direction[1];
        if (newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length) {
          continue;
        }
        int absDiff = Math.max(minPath, Math.abs(heights[row][col] - heights[newRow][newCol]));
        if (absDiff < dp[newRow][newCol]) {
          dp[newRow][newCol] = absDiff;
          priorityQueue.add(new int[]{newRow, newCol, absDiff});
        }
      }
    }

    return dp[heights.length - 1][heights[0].length - 1];

  }


  @Test
  public void test() {
    int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
    int[][] heights2 = {{1, 2}, {3, 4}};
    System.out.println(minimumEffortPath(heights));
  }

}
