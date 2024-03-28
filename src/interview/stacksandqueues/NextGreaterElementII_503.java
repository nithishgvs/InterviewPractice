package interview.stacksandqueues;

import java.util.Stack;

public class NextGreaterElementII_503 {

  public int[] nextGreaterElements(int[] nums) {
    int[] result = new int[nums.length];

    Stack<Integer> stack = new Stack<>();

    //Add elements from last to first so for the last element of nums we start checking from start

    for (int i = nums.length - 1; i > -1; i--) {
      stack.add(nums[i]);
    }

    for (int i = nums.length - 1; i > -1; i--) {

      while (!stack.isEmpty() && stack.peek() <= nums[i]) {
        stack.pop();
      }
      result[i] = stack.isEmpty() ? -1 : stack.peek();
      //Add the number as this is used for the next one
      stack.push(nums[i]);
    }

    return result;
  }

}
