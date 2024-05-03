package interview.dynamicprogramming;

import org.junit.Test;

public class LongestCommonSubsequence_1143 {

  public int longestCommonSubsequence(String text1, String text2) {

    int[][] dp = new int[text1.length() + 1][text2.length() + 1];

    //First row and col have all zeroes base condition

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {

        if (text2.charAt(j - 1) == text1.charAt(i - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[text1.length()][text2.length()];

  }

  @Test
  public void test() {
    System.out.println(longestCommonSubsequence("abcde", "ace"));
  }

}
