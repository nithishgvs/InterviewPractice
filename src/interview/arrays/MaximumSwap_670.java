package interview.arrays;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class MaximumSwap_670 {

  public int maximumSwap(int num) {

    char[] chars = String.valueOf(num).toCharArray();
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < chars.length; i++) {
      map.put(Character.getNumericValue(chars[i]), i);
    }

    for (int i = 0; i < chars.length; i++) {
      int value = Character.getNumericValue(chars[i]);
      for (int j = 9; j > -1; j--) {
        if (j > value && map.containsKey(j) && map.get(j) > i) {
          //Swap
          char tmp = chars[i];
          chars[i] = chars[map.get(j)];
          chars[map.get(j)] = tmp;
          return Integer.valueOf(String.valueOf(chars));
        }
      }
    }

    return num;

  }


  @Test
  public void test() {
    System.out.println(maximumSwap(9973));
  }

}
