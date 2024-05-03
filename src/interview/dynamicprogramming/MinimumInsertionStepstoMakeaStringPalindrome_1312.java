package interview.dynamicprogramming;

import org.junit.Test;

public class MinimumInsertionStepstoMakeaStringPalindrome_1312 {

  public int minInsertions(String s) {

    String reverse = new StringBuilder(s).reverse().toString();

    int[][] dp = new int[s.length() + 1][reverse.length() + 1];

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp.length; j++) {
        if (s.charAt(i-1) == reverse.charAt(j-1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return s.length() - dp[s.length()][s.length()];
  }

  @Test
  public void test() {
    System.out.println(minInsertions("mbadm"));
  }

}
