package interview.salesforce;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class BestTimetoBuyandSellStockwithCooldown_309 {

  /**
   * State Buying/Selling
   * Buy->i+1 (index will be increased)
   * Sell->i+2(Because we need to have a cool down day)
   * https://www.youtube.com/watch?v=I7j0F7AHpb8
   */

  Map<String, Integer> dp = new HashMap<>();

  public int maxProfit(int[] prices) {
    return dfs(0, true, prices);
  }


  private int dfs(int index, boolean buying, int[] prices) {
    if (index >= prices.length) {
      return 0;
    }

    String currIndex = index + "|" + buying;

    if (dp.containsKey(currIndex)) {
      return dp.get(currIndex);
    }

    if (buying) {
      int buy = dfs(index + 1, !buying, prices) - prices[index];
      int coolDown = dfs(index + 1, buying, prices);
      dp.put(currIndex, Math.max(buy, coolDown));
    } else {
      //Sell case
      int sell = dfs(index + 2, !buying, prices) + prices[index];
      int coolDown = dfs(index + 1, buying, prices);
      dp.put(currIndex, Math.max(sell, coolDown));
    }

    return dp.get(currIndex);
  }

  @Test
  public void test() {
    int[] nums = {1, 2, 3, 0, 2};
    System.out.println(maxProfit(nums));
  }


}
