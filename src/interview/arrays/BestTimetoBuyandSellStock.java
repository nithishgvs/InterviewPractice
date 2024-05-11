package interview.arrays;

import org.junit.Test;

public class BestTimetoBuyandSellStock {

  public int maxProfit(int[] prices) {

    int minPrice = prices[0];
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      maxProfit = Math.max(maxProfit, prices[i] - minPrice);
      minPrice = Math.min(minPrice, prices[i]);
    }

    return maxProfit;


  }


  @Test
  public void test() {
    int[] prices = {7, 6, 4, 3, 1};
    System.out.println(maxProfit(prices));
  }

}
