package interview.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitinJobScheduling_1235 {

  class Job {

    int startTime;
    int endTime;
    int profit;

    public Job(int startTime, int endTime, int profit) {
      this.startTime = startTime;
      this.endTime = endTime;
      this.profit = profit;
    }
  }

  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

    int max = 0;

    Job[] jobs = new Job[startTime.length];

    for (int i = 0; i < startTime.length; i++) {
      Job job = new Job(startTime[i], endTime[i], profit[i]);
      jobs[i] = job;
    }

    //We should start Job by end Index here
    Arrays.sort(jobs, Comparator.comparingInt(a -> a.endTime));

    int[] dp = new int[startTime.length];
    dp[0] = jobs[0].profit;
    max = dp[0];

    for (int i = 1; i < jobs.length; i++) {
      Job currentJob = jobs[i];
      int startIdx = currentJob.startTime;
      int currentProfit = currentJob.profit;
      int nonOverlappingIndex = findNonOverlappingIndex(0, i - 1, jobs, startIdx);
      if (nonOverlappingIndex != -1) {
        dp[i] = Math.max(dp[i - 1], currentProfit + dp[nonOverlappingIndex]);
      } else {
        dp[i] = Math.max(currentProfit, dp[i - 1]);
      }
      max = Math.max(dp[i], max);
    }

    return max;

  }

  private int findNonOverlappingIndex(int l, int h, Job[] jobs, int startIndex) {
    int index = -1;

    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (jobs[mid].endTime <= startIndex) {
        index = mid;
        l = mid + 1;
      } else {
        h = mid - 1;
      }

    }
    return index;
  }
}
