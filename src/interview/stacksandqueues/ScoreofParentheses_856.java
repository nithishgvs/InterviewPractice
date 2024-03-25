package interview.stacksandqueues;

import java.util.Stack;
import org.junit.Test;

public class ScoreofParentheses_856 {

  public int scoreOfParentheses(String s) {


    int score = 0;

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {

      char ch = s.charAt(i);

      if (ch == '(') {
        stack.add(-1);
      } else {
        if (stack.peek() == -1) {
          stack.pop();
          stack.add(1);
        } else {
          int sum = 0;
          while (stack.peek() != -1) {
            sum += stack.pop();
          }
          stack.pop();
          stack.add(2 * sum);
        }
      }

    }

    while (!stack.isEmpty()) {
      score += stack.pop();
    }

    return score;

  }


  @Test
  public void test() {
    System.out.println(scoreOfParentheses("()()"));
  }
}
