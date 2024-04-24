package interview.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import org.junit.Test;

public class MinimumNumberofArrowstoBurstBalloons_452 {


  public int findMinArrowShots(int[][] points) {

    Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

    int cut = points[0][1];

    int total = 1;

    for (int i = 1; i < points.length; i++) {
      if (points[i][0] > cut) {
        cut = points[i][1];
        total++;
      }
      cut = Math.min(points[i][1], cut);
    }

    return total;
  }

  @Test
  public void test() {
    int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
    int[][] points1 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
    int[][] points2 = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6},
        {2, 8}};
    findMinArrowShots(points2);
  }

}
