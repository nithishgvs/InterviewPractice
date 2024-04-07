package interview.arrays;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class TaskSchedulerII_2365 {


  public long taskSchedulerII(int[] tasks, int space) {

    long days = 0;
    Map<Integer, Long> taskMap = new HashMap<>();
    for (int i = 0; i < tasks.length; i++) {
      days++;
      if (taskMap.containsKey(tasks[i])) {
        double net = days - taskMap.get(tasks[i]) - 1;
        if (net < space) {
          days += space - net;
        }
      }
      taskMap.put(tasks[i], days);

    }
    return days;
  }

  @Test
  public void test() {
    int[] tasks = {5, 8, 8, 5};
    taskSchedulerII(tasks, 2);
  }


}
