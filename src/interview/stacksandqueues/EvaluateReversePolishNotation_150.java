package interview.stacksandqueues;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {


  public int evalRPN(String[] tokens) {

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < tokens.length; i++) {
      int elem1;
      int elem2;
      switch (tokens[i]) {

        case ("+"):
          elem1 = stack.pop();
          elem2 = stack.pop();
          stack.add(elem2 + elem1);
          break;
        case ("-"):
          elem1 = stack.pop();
          elem2 = stack.pop();
          stack.add(elem2 - elem1);
          break;
        case ("*"):
          elem1 = stack.pop();
          elem2 = stack.pop();
          stack.add(elem2 * elem1);
          break;
        case ("/"):
          elem1 = stack.pop();
          elem2 = stack.pop();
          stack.add(elem2 / elem1);
          break;

        default:
          stack.add(Integer.valueOf(tokens[i]));

      }
    }

    return stack.pop();
  }
}
