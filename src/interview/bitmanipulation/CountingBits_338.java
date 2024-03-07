package interview.bitmanipulation;

public class CountingBits_338 {

  public int[] countBits(int n) {
    /**
     * right shift operation divides number by 2, for odd numbers right most significant bit is 1 and it will be kicked out after we do  right shift operation
     *
     * for number we would have already known dp[number-2] as we construct the array from scratch
     *
     * for 2 number/2 is 1 dp[1] is already present as it is even we copy the value
     *
     * for 3 number/2 is 1 dp[1] as its odd we add 1
     */
    int[] dp = new int[n + 1];
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      boolean isEven = (i % 2 == 0);
      int half = i >> 1;
      if (!isEven) {
        dp[i] = dp[half] + 1;
      } else {
        dp[i] = dp[half];
      }
    }

    return dp;
  }
}
