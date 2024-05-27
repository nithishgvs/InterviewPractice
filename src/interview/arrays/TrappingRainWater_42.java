package interview.arrays;

public class TrappingRainWater_42 {

  //Min(leftMax,rightMax)-height[i]

  public int trap(int[] height) {
    int water = 0;

    int maxSoFar = 0;
    int[] maxRight = new int[height.length];

    int maxLeft = 0;

    for (int i = height.length - 1; i >= 0; i--) {
      if (height[i] > maxSoFar) {
        maxSoFar = height[i];
        maxRight[i] = height[i];
      } else {
        maxRight[i] = maxSoFar;
      }
    }

    for (int i = 0; i < height.length; i++) {
      water += Integer.max(Integer.min(maxLeft, maxRight[i]) - height[i], 0);
      if (height[i] > maxLeft) {
        maxLeft = height[i];
      }
    }

    return water;
  }


}
