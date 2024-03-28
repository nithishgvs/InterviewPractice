package interview.stacksandqueues;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinStringII_1209 {

  class StackElement {

    char character;
    int count;

    public StackElement(char character, int count) {
      this.character = character;
      this.count = count;
    }
  }

  public String removeDuplicates(String s, int k) {
    Stack<StackElement> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (!stack.isEmpty() && stack.peek().character == ch) {

        if (stack.peek().count == k - 1) {
          stack.pop();
        } else {
          int previousFreq = stack.pop().count;
          stack.add(new StackElement(ch, previousFreq + 1));
        }

      } else {
        stack.add(new StackElement(ch, 1));
      }
    }

    StringBuilder stringBuilder = new StringBuilder();
    while (!stack.isEmpty()) {
      StackElement popped = stack.pop();
      int freq = popped.count;
      while (freq > 0) {
        stringBuilder.append(popped.character);
        freq--;
      }
    }

    return stringBuilder.reverse().toString();
  }
}
