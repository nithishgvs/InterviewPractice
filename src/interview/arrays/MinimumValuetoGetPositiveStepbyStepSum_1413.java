package interview.arrays;

public class MinimumValuetoGetPositiveStepbyStepSum_1413 {


  public int minStartValue(int[] nums) {

    int prefixSum = 0;
    int minValue = Integer.MAX_VALUE;

    for (int n : nums) {
      //We calculate min value
      prefixSum += n;
      minValue = Math.min(minValue, prefixSum);
    }

    //If minValue is negative we need to add one to the absolute value of minValue if result is positive we return 1 which is first positive value
    return minValue < 0 ? 1 + Math.abs(minValue) : 1;

  }

}
