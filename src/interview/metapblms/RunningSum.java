package interview.metapblms;

import org.junit.Test;

public class RunningSum {

  /**
   * Given array of nums, return an array of the running sum divided by window length k. (i.e. nums
   * = [1, 2, 3, 4, 5], k = 3 => [2, 3, 4]
   */

  public int[] runningSum(int[] nums, int k) {

    int[] res = new int[nums.length - k + 1];

    int left = 0;
    int sum = 0;

    int idx = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      if (i - left + 1 == k) {
        res[idx++] = sum / k;
        sum -= nums[left];
        left++;
      }

    }

    return res;
  }


  @Test
  public void test() {
    int[] nums = {1, 2, 3, 4, 5};
    System.out.println(runningSum(nums, 3));
  }

}
