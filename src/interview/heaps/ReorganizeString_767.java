package interview.heaps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.Test;

public class ReorganizeString_767 {


  public String reorganizeString(String s) {

    Map<Character, Integer> map = new HashMap<>();

    StringBuilder stringBuilder = new StringBuilder();

    for (char ch : s.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
        (a, b) -> b.getValue().compareTo(a.getValue()));

    maxHeap.addAll(map.entrySet());

    Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

    while (!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> entry = maxHeap.poll();
      stringBuilder.append(entry.getKey());
      queue.add(entry);
      while (queue.size() > 1) {
        Map.Entry<Character, Integer> queuePolled = queue.poll();
        if (queuePolled.getValue() > 1) {
          queuePolled.setValue(queuePolled.getValue() - 1);
          maxHeap.add(queuePolled);
        }
      }
    }

    return stringBuilder.length() == s.length() ? stringBuilder.toString() : "";
  }

  @Test
  public void test() {
    System.out.println(reorganizeString("aaab"));
  }
}
