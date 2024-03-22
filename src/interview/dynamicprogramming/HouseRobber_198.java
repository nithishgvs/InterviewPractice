package interview.dynamicprogramming;

public class HouseRobber_198 {

  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    int max = nums[0];

    for (int i = 1; i < nums.length; i++) {
      dp[i + 1] = Math.max(nums[i] + dp[i - 1], dp[i]);
      max = Math.max(max, dp[i + 1]);

    }

    return max;
  }
}
