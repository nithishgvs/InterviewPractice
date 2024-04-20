package interview.stacksandqueues;

import java.util.Stack;
import org.junit.Test;

public class BasicCalculator2_227 {


  public int calculate(String s) {

    s = s.trim();
    char sign = '+';

    int result = 0;

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {

      char character = s.charAt(i);

      if (Character.isDigit(character)) {
        result = (character - '0') + result * 10;
      }

      if (!Character.isSpaceChar(character) && !Character.isDigit(character)
          || i == s.length() - 1) {
        switch (sign) {
          case '+':
            stack.push(result);
            break;
          case '-':
            stack.push(result * -1);
            break;
          case '*':
            stack.push(stack.pop() * result);
            break;
          case '/':
            stack.push(stack.pop() / result);
            break;

        }
        sign = character;
        result = 0;
      }
    }

    while (!stack.isEmpty()) {
      result += stack.pop();
    }

    return result;
  }


  public int calculate1(String s) {

    int num = 0;
    char operator = '+';
    int last = 0, sum = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (Character.isDigit(c)) {
        num = num * 10 + (c - '0');
      }

      if (isOperator(c) || i == s.length() - 1) {
        if (operator == '+') {
          sum += last;
          last = num;
        } else if (operator == '-') {
          sum += last;
          last = -num;
        } else if (operator == '*') {
          last *= num;
        } else if (operator == '/') {
          last /= num;
        }

        num = 0;
        operator = c;
      }
    }

    return sum + last;
  }

  private boolean isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
  }

  @Test
  public void test() {
    System.out.println(calculate1(" 3/2 "));
  }

}
