package interview.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class MinimumNumberofKeypresses {

  public int minimumKeypresses(String s) {

    int total = 0;

    //allocate Max frequency ones first not greedy

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    int totalAllocated = 0;

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
        (a, b) -> Integer.compare(b.getValue(), a.getValue()));

    maxHeap.addAll(map.entrySet());

    while (!maxHeap.isEmpty()) {

      Map.Entry<Character, Integer> entry = maxHeap.poll();
      if (totalAllocated < 9) {
        total += entry.getValue() * 1;
      } else if (totalAllocated < 18) {
        total += entry.getValue() * 2;
      } else {
        total += entry.getValue() * 3;
      }
      totalAllocated++;
    }

    return total;
  }

  @Test
  public void test() {
    System.out.println(minimumKeypresses("aaaaaaaabcdefgggghijkllllllllllmmmnoppponono"));
  }

}
