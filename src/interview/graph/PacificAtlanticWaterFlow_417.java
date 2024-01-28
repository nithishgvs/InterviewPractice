package interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class PacificAtlanticWaterFlow_417 {

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> result = new ArrayList<>();

    boolean[][] pacific = new boolean[heights.length][heights[0].length];
    boolean[][] atlantic = new boolean[heights.length][heights[0].length];

    //pacific top edge & atlantic bottom edge
    for (int j = 0; j < heights[0].length; j++) {
      dfs(0, j, pacific, heights);
      dfs(heights.length - 1, j, atlantic, heights);
    }

    //pacific left edge & atlantic right edge
    for (int i = 0; i < heights.length; i++) {
      dfs(i, 0, pacific, heights);
      dfs(i, heights[0].length - 1, atlantic, heights);
    }

    for (int i = 0; i < heights.length; i++) {
      for (int j = 0; j < heights[0].length; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          result.add(Arrays.asList(i, j));
        }
      }
    }

    return result;
  }

  private void dfs(int currRow, int currCol, boolean[][] currentOcean, int[][] heights) {
    if (!currentOcean[currRow][currCol]) {
      currentOcean[currRow][currCol] = true;
      int[][] diagonals = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
      for (int[] diagonal : diagonals) {
        int adjRow = currRow + diagonal[0];
        int adjCol = currCol + diagonal[1];
        /**
         * Remember we are moving from boundary to inside cells, the condition given in the question states that inner cells with higher values can take there water to the oceans using low values cells but since we are moving from boundary to the inner cells so we will reverse this condition and say we can move to those cells which has values higher than my current cell.
         */
        if (adjRow > -1 && adjRow < heights.length && adjCol > -1 && adjCol < heights[0].length
            && heights[adjRow][adjCol] >= heights[currRow][currCol]) {
          dfs(adjRow, adjCol, currentOcean, heights);
        }
      }
    }
  }

  @Test
  public void test() {
    int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}};
    pacificAtlantic(heights);
  }


}
