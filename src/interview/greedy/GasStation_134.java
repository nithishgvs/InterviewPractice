package interview.greedy;

import java.util.Arrays;

public class GasStation_134 {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    if (Arrays.stream(cost).reduce(0, (a, b) -> a + b) - Arrays.stream(gas)
        .reduce(0, (a, b) -> a + b) > 0) {
      return -1;
    }

    int start = 0;

    int currentFuel = 0;

    for (int i = 0; i < gas.length; i++) {
      currentFuel += gas[i] - cost[i];
      if (currentFuel < 0) {
        start = i + 1;
        currentFuel = 0;
      }
    }

    return start;
  }


}
