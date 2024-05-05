package interview.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency_451 {

  public String frequencySort(String s) {

    Map<Character, Integer> map = new HashMap<>();

    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
        (a, b) -> Integer.compare(b.getValue(), a.getValue()));

    maxHeap.addAll(map.entrySet());

    StringBuilder sb = new StringBuilder();

    while (!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> polled = maxHeap.poll();
      int freq = polled.getValue();

      while (freq > 0) {
        sb.append(polled.getKey());
        freq--;
      }
    }
    return sb.toString();
  }

}
