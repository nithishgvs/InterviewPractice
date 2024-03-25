package interview.stacksandqueues;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import org.junit.Test;

public class ExclusiveTimeofFunctions_636 {

  class StackElement {

    int function;
    String startOrEnd;
    int start;

    public StackElement(int function, String startOrEnd, int start) {
      this.function = function;
      this.startOrEnd = startOrEnd;
      this.start = start;
    }
  }

  public int[] exclusiveTime(int n, List<String> logs) {

    int[] result = new int[n];

    Stack<StackElement> stack = new Stack<>();

    for (int i = 0; i < logs.size(); i++) {
      String[] split = logs.get(i).split(":");
      int function = Integer.valueOf(split[0]);
      String type = split[1];
      int startTime = Integer.valueOf(split[2]);
      if (stack.isEmpty()) {
        stack.add(new StackElement(function, type, startTime));
      } else {
        if (stack.peek().startOrEnd.equals(type)) {
          result[stack.peek().function] += startTime - stack.peek().start;
          stack.add(new StackElement(function, type, startTime));
        } else {
          result[function] += startTime - stack.pop().start + 1;
          if (!stack.isEmpty()) {
            StackElement poll = stack.pop();
            stack.add(new StackElement(poll.function, poll.startOrEnd, startTime + 1));
          }
        }

      }
    }

    return result;

  }


  @Test
  public void test() {
    String val = "0:start:0,0:start:2,0:end:5,1:start:6,1:end:6,0:end:7";
    String[] vals = val.split(",");
    List<String> logs = Arrays.stream(vals).collect(Collectors.toList());
    exclusiveTime(2, logs);
  }
}
