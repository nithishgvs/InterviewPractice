package interview.arrays;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.Test;

public class TwoCityScheduling_1029 {


  public int twoCitySchedCost(int[][] costs) {

    int minCost = 0;

    Arrays.sort(costs, Comparator.comparingInt(a -> (a[1] - a[0])));

    int idx = 0;
    for (int i = 0; i < costs.length; i++) {

      if (idx < costs.length / 2) {
        minCost += costs[i][1];
      } else {
        minCost += costs[i][0];
      }

      idx++;

    }

    return minCost;

  }


  @Test
  public void test() {
    System.out.println(twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
  }
}
