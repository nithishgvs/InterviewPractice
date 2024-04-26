package interview.stacksandqueues;

import java.util.Stack;

public class Pattern132_456 {


  public boolean find132pattern(int[] nums) {
    Stack<Integer> stack = new Stack<>();

    int max = Integer.MIN_VALUE;

    //Start from the end of the stack
    //If current Elem is greater than the stack values pop them and assign the values to the max
    for (int i = nums.length - 1; i > -1; i--) {
      if (nums[i] < max) {
        return true;
      }

      while (!stack.isEmpty() && nums[i] > stack.peek()) {
        max = stack.pop();
      }

      stack.add(nums[i]);

    }

    return false;
  }
}
