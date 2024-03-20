package interview.stacksandqueues;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid_921 {

  public int minAddToMakeValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') {
        stack.pop();
        continue;
      } else if (ch == '(' || ch == ')') {
        stack.add(ch);
      }
    }

    return stack.size();
  }
}
