package interview.dynamicprogramming;

import org.junit.Test;

public class ValidPalindromeIII_1216 {

  public boolean isValidPalindrome(String s, int k) {
    int[][] dp = new int[s.length()][s.length()];

    for (int i = 0; i < dp.length; i++) {
      dp[i][i] = 1;
    }

    //int l = 1;
    for (int l = 1; l < dp.length; l++) {
      //int i=0;
      for (int i = 0; i < dp.length; i++) {
        int j = i + l;
        if (j < dp.length) {
          if (s.charAt(i) != s.charAt(j)) {
            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
          } else {
            dp[i][j] = 2 + dp[i + 1][j - 1];
          }
        }
      }
    }

    return dp[0][s.length() - 1] >= s.length() - k;
  }


  @Test
  public void test() {
    System.out.println(isValidPalindrome("abbababa", 1));
  }

}
