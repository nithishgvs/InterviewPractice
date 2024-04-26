package interview.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class MinimumNumberofKeypresses_2268 {


  public int minimumKeypresses(String s) {
    Map<Character, Integer> freqMap = new HashMap<>();

    int minKeys = 0;

    for (char ch : s.toCharArray()) {
      freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
    }

    PriorityQueue<Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
        (a, b) -> b.getValue().compareTo(a.getValue()));
    maxHeap.addAll(freqMap.entrySet());
    int allocated = 0;
    while (!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> polled = maxHeap.poll();

      if (allocated < 9) {
        minKeys += polled.getValue() * 1;
      } else if (allocated < 18) {
        minKeys += polled.getValue() * 2;
      } else {
        minKeys += polled.getValue() * 3;
      }
      allocated++;

    }

    return minKeys;
  }
}
