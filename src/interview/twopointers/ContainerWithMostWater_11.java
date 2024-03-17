package interview.twopointers;

import org.junit.Test;

public class ContainerWithMostWater_11 {


  public int maxArea(int[] height) {

    int maxArea = 0;

    int start = 0;
    int end = height.length - 1;

    while (start < end) {

      maxArea = Math.max(maxArea, Math.min(height[end], height[start]) * (end - start));
      System.out.println(maxArea);

      if (height[end] > height[start]) {
        start++;
      } else if (height[end] < height[start]) {
        end--;
      } else {
        start++;
        end--;
      }

    }

    return maxArea;

  }


  @Test
  public void test() {
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(maxArea(height));
  }

}
