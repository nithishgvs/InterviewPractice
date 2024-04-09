package interview.dynamicprogramming;

import org.junit.Test;

public class DecodeWays_91 {

  //Asked in VMWare
  //https://www.youtube.com/watch?v=cQX3yHS0cLo
  public int numDecodings(String s) {
    int[] dp = new int[s.length() + 1];

    //Dp of array of size 0 is 1
    dp[0] = 1;
    //Dp[1] is value starts with 0 value is 0
    dp[1] = s.charAt(0) != '0' ? 1 : 0;

    for (int i = 2; i <= s.length(); i++) {
      int first = Integer.valueOf(s.substring(i - 1, i));
      int second = Integer.valueOf(s.substring(i - 2, i));

      /**
       * 12
       *
       * No of ways to decode 12 is number of ways to decode 2 and 12
       */
      if (first > 0 && first <= 9) {
        dp[i] += dp[i - 1];
      }
      if (second >= 10 && second <= 26) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[s.length()];
  }

  @Test
  public void test() {
    numDecodings("12");
  }

}
