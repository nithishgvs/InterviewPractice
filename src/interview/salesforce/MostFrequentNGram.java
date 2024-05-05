package interview.salesforce;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class MostFrequentNGram {

  //Example: for ‘abcdabxexexe’ and 2 returns ‘xe’.


  public String mostCommonNGram(String word, int n) {

    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i <= word.length() - n; i++) {
      String sub = word.substring(i, i + n);
      map.put(sub, map.getOrDefault(sub, 0) + 1);
    }

    PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
        (a, b) -> Integer.compare(b.getValue(), a.getValue()));

    maxHeap.addAll(map.entrySet());

    return maxHeap.poll().getKey();
  }

  @Test
  public void test() {
    System.out.println(mostCommonNGram("abcdabxexexe", 2));
  }


}
