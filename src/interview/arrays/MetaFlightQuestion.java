package interview.arrays;

import org.junit.Test;

public class MetaFlightQuestion {

  /**
   * There are 2 arrays which denote departing and returning flights with the respective indexes
   * being time and the values of the array being the cost it takes for the flight. Return the
   * minimum cost for a round trip provided the return flight can only be taken at a time post
   * departing flight time (i.e if departing at time i, one can catch a returning flight only from
   * time (i+1) onwards). For eg departing = [1,2,3,4] and returning = [4,3,2,1], the minimum cost
   * for round trip will be 2 i.e departing[0] + returning[3]. Solve this is O(n) time
   */

  public static int minCost(int[] depart, int[] ret) {
    int n = depart.length;
    int[] minRet = new int[n];
    minRet[n - 1] = ret[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      minRet[i] = Math.min(minRet[i + 1], ret[i]);
    }
    int minCost = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      minCost = Math.min(minCost, depart[i] + minRet[i]);
    }
    return minCost;
  }

  @Test

  public void test() {
    //departing = [1,2,3,4] and returning = [4,3,2,1],
    int[] depart = {1, 2, 3, 4};
    int[] ret = {4, 3, 2, 1};

    System.out.println(minCost(depart, ret));
  }

}
