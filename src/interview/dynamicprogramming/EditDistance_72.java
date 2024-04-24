package interview.dynamicprogramming;

public class EditDistance_72 {

  public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    //https://www.youtube.com/watch?v=b6AGUjqIPsA

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {

        if (i == 0 & j == 0) {
          //Null string condition
          dp[i][j] = 0;
        } else if (i == 0) {
          //First row null to word1 conversion equal to total chars
          dp[i][j] = dp[i][j - 1] + 1;
        } else if (j == 0) {
          //First row null to word1 conversion equal to total chars

          dp[i][j] = dp[i - 1][j] + 1;
        } else {
          if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            //Take diagonal
            dp[i][j] = dp[i - 1][j - 1];
          } else {
            //-----> insert
            // Down arrow remove Diagonal replace
            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]))+1;
          }
        }
      }
    }


    return dp[word1.length()][word2.length()];
  }
}
