package interview.dynamicprogramming;

public class MaximalSquare_221 {

  public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0)
      return 0;

    int max = 0;

    int dp[][] = new int[matrix.length][matrix[0].length];


    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (matrix[i][j] == '1') {
          if (i - 1 > -1 && j - 1 > -1) {
            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
          } else {
            dp[i][j] = 1;
          }
          max = Math.max(max, dp[i][j]);
        }
      }
    }


    return max * max;
  }

}
