package interview.stacksandqueues;

import java.util.Stack;
import org.junit.Test;

public class MinimumRemovetoMakeValidParentheses {


  class StackHelper {

    Character ch;
    Integer pos;

    public StackHelper(Character ch, Integer pos) {
      this.ch = ch;
      this.pos = pos;
    }
  }


  public String minRemoveToMakeValid(String s) {

    Stack<StackHelper> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (!stack.isEmpty() && ch == ')' && stack.peek().ch == '(') {
        stack.pop();
      } else if (ch == ')' || ch == '(') {
        stack.add(new StackHelper(ch, i));
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
