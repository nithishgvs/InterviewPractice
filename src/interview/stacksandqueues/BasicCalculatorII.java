package interview.stacksandqueues;

import java.util.Stack;

public class BasicCalculatorII {


  public int calculate(String s) {

    int result = 0;
    char sign = '+';

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isDigit(ch)) {
        result = (ch - '0') + (10 * result);
      }
      if (!Character.isSpaceChar(ch) && !Character.isDigit(ch) || i == s.length() - 1) {
        switch (sign) {
          case '+':
            stack.push(result);
            break;
          case '-':
            stack.push(result * -1);
            break;
          case '/':
            stack.push(stack.pop() / result);
            break;
          case '*':
            stack.push(stack.pop() * result);
            break;
        }
        result = 0;
        sign = ch;
      }

    }

    int sum = 0;
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }

    return sum;
  }

}
