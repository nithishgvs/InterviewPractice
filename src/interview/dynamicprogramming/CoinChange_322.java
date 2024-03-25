package interview.dynamicprogramming;

import java.util.Arrays;
import org.junit.Test;

public class CoinChange_322 {


  public int coinChange(int[] coins, int amount) {

    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    //Base condition number of ways to make 0 is 0
    dp[0] = 0;

    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (i >= coins[j]) {
          //If sum we wnated is greater than coins we need to include this coin and see we can make value
          dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
        }
      }
    }

    return dp[amount] > amount ? -1 : dp[amount];

  }


  @Test
  public void test() {
    int[] coins = {2};
    System.out.println(coinChange(coins, 3));
  }


}
