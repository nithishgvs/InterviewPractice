package interview.priorityqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.Test;

public class TaskScheduler_621 {

  public int leastInterval(char[] tasks, int n) {

    Map<Character, Integer> helperMap = new HashMap<>();

    for (char ch : tasks) {
      int value = helperMap.getOrDefault(ch, 0);
      helperMap.put(ch, value + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue());

    Queue<Map.Entry<Character, Integer>> queue = new ArrayDeque<>();

    priorityQueue.addAll(helperMap.entrySet());

    StringBuilder result = new StringBuilder();

    while (!priorityQueue.isEmpty()) {

      for (int i = 0; i < n + 1; i++) {
        Character character = priorityQueue.isEmpty() ? '\0' : priorityQueue.peek().getKey();
        result.append(character);
        if (character != '\0') {
          queue.add(priorityQueue.poll());
        }
      }

      while (!queue.isEmpty()) {
        Map.Entry<Character, Integer> polled = queue.poll();
        polled.setValue(polled.getValue() - 1);
        if (polled.getValue() > 0) {
          priorityQueue.add(polled);
        }
      }
    }

    return result.toString().trim().length();

  }


  @Test
  public void test() {
    char[] tasks = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    System.out.println(leastInterval(tasks, 2));
  }

  @Test
  public void test2() {
    char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
    System.out.println(leastInterval(tasks, 2));
  }

}
