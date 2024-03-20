package interview.stacksandqueues;

import java.util.Stack;

public class BuildingsWithAnOceanView_1762 {


  public int[] findBuildings(int[] heights) {
    Stack<Integer> stack = new Stack<>();

    stack.add(heights.length - 1);

    int maxHeightIndex = heights.length - 1;

    for (int i = heights.length - 2; i > -1; i--) {
      if (heights[i] > heights[maxHeightIndex]) {
        stack.push(i);
        maxHeightIndex = i;
      }
    }

    int[] result = new int[stack.size()];
    int i = 0;

    while (!stack.isEmpty()) {
      result[i] = stack.pop();
      i++;
    }

    return result;
  }

}
