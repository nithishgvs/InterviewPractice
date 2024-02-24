package interview.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequentWords_692 {

  public List<String> topKFrequent(String[] words, int k) {

    Map<String, Integer> wordCountMap = Arrays.stream(words)
        .collect(Collectors.groupingBy(word -> word, Collectors.summingInt(word -> 1)));

    PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
      if (a.getValue() == b.getValue()) {
        return a.getKey().compareTo(b.getKey());
      }
      return b.getValue() - a.getValue();
    });

    maxHeap.addAll(wordCountMap.entrySet());
    List<String> result = new ArrayList<>();
    while (k > 0) {
      result.add(maxHeap.poll().getKey());
      k--;
    }

    return result;

  }
}
