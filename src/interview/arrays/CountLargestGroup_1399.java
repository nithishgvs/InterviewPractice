package interview.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class CountLargestGroup_1399 {


  public int countLargestGroup(int n) {

    Map<Integer, List<Integer>> map = new HashMap<>();

    int max = 0;

    for (int i = 1; i <= n; i++) {
      int count = countDigits(i);
      if (!map.containsKey(count)) {
        map.put(count, new ArrayList<>());
      }
      map.get(count).add(i);
      max = Math.max(max, map.get(count).size());

    }

    int count = 0;

    for (Integer k : map.keySet()) {
      if (map.get(k).size() == max) {
        count++;
      }
    }

    return count;

  }

  private int countDigits(int i) {
    if (i == 0) {
      return 0;
    }
    return i % 10 + countDigits(i / 10);
  }


  @Test
  public void test() {
    System.out.println(countLargestGroup(13));
  }

}
