package interview.searchingsorting;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.Test;

public class MostProfitAssigningWork_868 {


  class Pair {

    int difficulty;
    int profit;

    public Pair(int difficulty, int profit) {
      this.difficulty = difficulty;
      this.profit = profit;
    }
  }


  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

    int maxProfit = 0;

    Pair[] pairs = new Pair[difficulty.length];

    for (int i = 0; i < difficulty.length; i++) {
      pairs[i] = new Pair(difficulty[i], profit[i]);
    }
    Arrays.sort(pairs, Comparator.comparingInt(a -> a.difficulty));

    Arrays.sort(worker);

    int index = 0;
    int currentProfit = 0;

    for (int i = 0; i < worker.length; i++) {
      int currentWorkersAbility = worker[i];
      while (index < worker.length && pairs[index].difficulty <= currentWorkersAbility) {
        currentProfit = Math.max(currentProfit, pairs[index].profit);
        index++;
      }
      maxProfit += currentProfit;
    }

    return maxProfit;

  }


  @Test
  public void test() {
    int[] difficulty = {2, 4, 6, 8, 10};
    int[] profit = {10, 20, 30, 40, 50};
    int[] worker = {4, 5, 6, 7};
    System.out.println(maxProfitAssignment(difficulty, profit, worker));
  }

  @Test
  public void test1() {
    int[] difficulty = {68, 35, 52, 47, 86};
    int[] profit = {67, 17, 1, 81, 3};
    int[] worker = {92, 10, 85, 84, 82};
    System.out.println(maxProfitAssignment(difficulty, profit, worker));
  }


}
