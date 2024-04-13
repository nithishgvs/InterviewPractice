package interview.string;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class MaximumSwap {

  public int maximumSwap(int num) {

    String number = String.valueOf(num);
    char[] arr = number.toCharArray();

    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      indexMap.put(arr[i] - '0', i);
    }
    for (int i = 0; i < arr.length; i++) {
      for (int j = 9; j > -1; j--) {
        if (indexMap.containsKey(j) && j > arr[i] - '0' && indexMap.get(j) > i) {
          char val = arr[i];
          arr[i] = arr[indexMap.get(j)];
          arr[indexMap.get(j)] = val;
          return Integer.valueOf(String.valueOf(arr));
        }
      }
    }
    return Integer.valueOf(String.valueOf(arr));
  }

  @Test
  public void test1() {
    maximumSwap(2736);
  }


}
