package interview.arrays;

public class BestTimeToBuyAndSellStock_121 {

  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minBuy = prices[0];

    for (int i = 1; i < prices.length; i++) {
      maxProfit = Math.max(prices[i] - minBuy, maxProfit);
      minBuy = Math.min(minBuy, prices[i]);
    }
    return maxProfit;
  }
}
