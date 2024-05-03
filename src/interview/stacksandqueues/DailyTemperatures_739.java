package interview.stacksandqueues;

import java.util.Stack;

public class DailyTemperatures_739 {


  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int[] result = new int[temperatures.length];
    stack.add(temperatures.length - 1);
    for (int i = temperatures.length - 2; i > -1; i--) {
      while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        result[i] = stack.peek() - i;
      }

      stack.add(i);
    }


    return result;
  }

}
