package interview.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class BestMeetingPoint_296 {

  //https://www.youtube.com/watch?v=KfH51O3l2EM
  public int minTotalDistance(int[][] grid) {

    //Got to store all rows and columns in the sorted order and pick the median of these
    //Then calculate the Manhattan distance

    List<int[]> list = new ArrayList<>();
    List<Integer> rows = new ArrayList<>();
    List<Integer> cols = new ArrayList<>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          rows.add(i);
          cols.add(j);
          list.add(new int[]{i, j});
        }
      }
    }

    //Need to sort cols as they will not be in the right order
    Collections.sort(cols);

    int medianRow = rows.get(rows.size() / 2);
    int medianCol = cols.get(cols.size() / 2);

    int meetingPoint = 0;

    for (int[] point : list) {
      meetingPoint += Math.abs(point[0] - medianRow) + Math.abs(point[1] - medianCol);
    }

    return meetingPoint;

  }


  @Test
  public void test() {
    int[][] grid = {{1, 1}};
    System.out.println(minTotalDistance(grid));
  }

}
