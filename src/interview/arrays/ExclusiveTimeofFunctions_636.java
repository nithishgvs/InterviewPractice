package interview.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import org.junit.Test;

public class ExclusiveTimeofFunctions_636 {

  public int[] exclusiveTime(int n, List<String> logs) {
    int[] result = new int[n];
    if (n == 0 || logs == null || logs.size() == 0) {
      return result;
    }

    Stack<Integer> stack = new Stack<>();

    int prevTime = 0;

    for (int i = 0; i < logs.size(); i++) {
      String[] split = logs.get(i).split(":");

      Integer currTime = Integer.valueOf(split[2]);

      if ("start".equals(split[1])) {
        if (!stack.isEmpty()) {
          result[stack.peek()] += currTime - prevTime;
        }
        stack.add(Integer.valueOf(split[0]));
        prevTime = currTime;
      } else {
        //Ending now
        result[stack.pop()] += currTime - prevTime + 1;
        prevTime = currTime + 1;
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
  //"0:start:0","1:start:2","1:end:5","0:end:6"

  @Test
  public void test1() {
    List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
    exclusiveTime(2, logs);
  }
}
