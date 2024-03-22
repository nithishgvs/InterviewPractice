package interview.stacksandqueues;

import java.util.Stack;

public class SimplifyPath_71 {


  public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();

    String[] paths = path.split("/");

    for (String sub : paths) {
      if (sub.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else if (!sub.isEmpty() && !sub.equals("..") && !sub.equals(".")) {
        stack.push(sub);
      }

    }
    String[] array = new String[stack.size() * 2];
    int i = array.length - 1;
    while (!stack.isEmpty()) {
      array[i] = stack.pop();
      array[--i] = "/";
      i--;
    }
    if (array.length == 0) {
      array = new String[1];
      array[0] = "/";
    }

    return String.join("", array);
  }
}
