package interview.stacksandqueues;

import java.util.Stack;
import org.junit.Test;

public class MinimumRemovetoMakeValidParentheses {


  class StackElement {

    char ch;
    int pos;

    public StackElement(char ch, int pos) {
      this.ch = ch;
      this.pos = pos;
    }
  }


  public String minRemoveToMakeValid(String s) {

    Stack<StackElement> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(' || ch == ')') {
        if (!stack.isEmpty() && stack.peek().ch == '(' && ch == ')') {
          stack.pop();
        } else {
          stack.add(new StackElement(ch, i));
        }
      }
    }

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = s.length() - 1; i > -1; i--) {
      if (!stack.isEmpty() && stack.peek().pos == i) {
        stack.pop();
      } else {
        stringBuilder.append(s.charAt(i));
      }
    }

    return stringBuilder.reverse().toString();
  }


  @Test
  public void test() {
    System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
  }

}
