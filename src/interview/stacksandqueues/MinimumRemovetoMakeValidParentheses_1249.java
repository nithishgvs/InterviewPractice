package interview.stacksandqueues;

import java.util.Stack;
import org.junit.Test;

public class MinimumRemovetoMakeValidParentheses_1249 {

  class StackElement {

    char ch;
    int position;

    public StackElement(char ch, int position) {
      this.ch = ch;
      this.position = position;
    }
  }

  public String minRemoveToMakeValid(String s) {

    Stack<StackElement> stack = new Stack<>();

    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      boolean isNotChar = ch == '(' || ch == ')';

      if (isNotChar) {
        if (!stack.isEmpty() && stack.peek().ch == '(' && ch == ')') {
          stack.pop();
        } else {
          stack.push(new StackElement(ch, i));
        }
      }
    }

    for (int i = s.length() - 1; i > -1; i--) {
      if (!stack.isEmpty() && stack.peek().position == i) {
        stack.pop();
      } else {
        stringBuilder.append(s.charAt(i));
      }
    }

    return stringBuilder.reverse().toString();
  }


  @Test
  public void test(){
    minRemoveToMakeValid("a)b(c)d");
  }


}
