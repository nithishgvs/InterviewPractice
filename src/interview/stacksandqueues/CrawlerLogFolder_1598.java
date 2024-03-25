package interview.stacksandqueues;

import java.util.Stack;
import org.junit.Test;

public class CrawlerLogFolder_1598 {


  public int minOperations(String[] logs) {

    Stack<String> stack = new Stack<>();

    for (int i = 0; i < logs.length; i++) {
      String value = logs[i].replace("/", "");
      if (value.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else if (!value.equals(".")) {
        stack.add(value);
      }
    }

    return stack.size();

  }

  @Test
  public void test() {
    String[] logs = {"d1/", "d2/", "../", "d21/", "./"};
    minOperations(logs);
  }

}
