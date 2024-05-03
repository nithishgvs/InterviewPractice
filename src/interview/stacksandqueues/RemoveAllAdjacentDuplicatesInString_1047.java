package interview.stacksandqueues;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString_1047 {


  public String removeDuplicates(String s) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if (!stack.isEmpty() && stack.peek().equals(s.charAt(i))) {
        stack.pop();
      } else {
        stack.add(s.charAt(i));
      }
    }

    char[] arr = new char[stack.size()];
    int size = arr.length - 1;

    while (!stack.isEmpty()) {
      arr[size--] = stack.pop();
    }

    return String.valueOf(arr);
  }
}
