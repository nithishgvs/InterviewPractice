package interview.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.Test;

public class SingleThreadedCPU_1834 {

  private class Tasks {

    int index;
    int enqueueTime;
    int processingTime;

    public Tasks(int index, int enqueueTime, int processingTime) {
      this.index = index;
      this.enqueueTime = enqueueTime;
      this.processingTime = processingTime;
    }
  }


  public int[] getOrder(int[][] tasks) {

    int[] result = new int[tasks.length];

    Queue<Tasks> availableTasks = new PriorityQueue<>((a, b) -> {
      if (a.processingTime - b.processingTime != 0) {
        return Integer.compare(a.processingTime, b.processingTime);
      }
      return Integer.compare(a.index, b.index);
    });

    Queue<Tasks> processingQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.enqueueTime));

    for (int i = 0; i < tasks.length; i++) {
      processingQueue.add(new Tasks(i, tasks[i][0], tasks[i][1]));
    }

    int time = 1;

    int start = 0;

    while (!processingQueue.isEmpty() || !availableTasks.isEmpty()) {
      while (!processingQueue.isEmpty() && processingQueue.peek().enqueueTime <= time) {
        Tasks currTask = processingQueue.poll();
        availableTasks.add(currTask);
      }

      if (availableTasks.isEmpty()) {
        time = processingQueue.peek().enqueueTime;
      } else {
        Tasks tasksResult = availableTasks.poll();
        result[start++] = tasksResult.index;
        time += tasksResult.processingTime;
      }
    }

    return result;

  }

  @Test
  public void test() {
    int[][] tasks = {{46, 9}, {46, 42}, {30, 46}, {30, 13}, {30, 24}, {30, 5}, {30, 21}, {29, 46},
        {29, 41}, {29, 18}, {29, 16}, {29, 17}, {29, 5}, {22, 15}, {22, 13}, {22, 25}, {22, 49},
        {22, 44}};
    System.out.println(getOrder(tasks));
  }

  @Test
  public void test1() {
    int[][] tasks = {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
    System.out.println(getOrder(tasks));
  }

}
