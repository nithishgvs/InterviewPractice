package interview.dynamicprogramming;

public class CoinChangeII_518 {
  public int change(int amount, int[] coins) {
    // 0 to amount will be colums so amount+1
    //Edge case is empty [] no coins
    int[][] waysCache = new int[coins.length + 1][amount + 1];

    for (int col = 0; col <= amount; col++) {
      //Edge case to make amount without coins []
      waysCache[0][col] = 0;
    }

    for (int row = 1; row <= coins.length; row++) {
      //With each coin making change of 0 without using is 1
      waysCache[row][0] = 1;
    }

    for (int row = 1; row <= coins.length; row++) {
      for (int score = 1; score <= amount; score++) {
        int scoreValue = coins[row - 1];//current coin

        //Min value to make without using current coin
        int withoutThisScore = waysCache[row - 1][score];

        int withThisScore = 0;
        if (scoreValue <= score) {
          withThisScore = waysCache[row][score - scoreValue];
        }

        waysCache[row][score] = withoutThisScore + withThisScore;
      }

    }


    return waysCache[coins.length][amount];
  }
}
