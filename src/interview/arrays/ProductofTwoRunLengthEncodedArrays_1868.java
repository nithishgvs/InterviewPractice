package interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ProductofTwoRunLengthEncodedArrays_1868 {


  public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {

    List<List<Integer>> result = new ArrayList<>();

    int enc1Ptr = 0;
    int enc2Ptr = 0;

    while (enc1Ptr < encoded1.length && enc2Ptr < encoded2.length) {
      int[] first = encoded1[enc1Ptr];
      int[] second = encoded2[enc2Ptr];

      int min = Math.min(first[1], second[1]);

      if (result.size() > 0 && result.get(result.size() - 1).get(0) == first[0] * second[0]) {
        int previousIndex = result.size() - 1;
        result.set(previousIndex,
            Arrays.asList(first[0] * second[0], min + result.get(result.size() - 1).get(1)));
      } else {
        result.add(Arrays.asList(first[0] * second[0], min));
      }

      if (first[1] > second[1]) {
        encoded1[enc1Ptr][1] = first[1] - min;
        enc2Ptr++;
      } else if (first[1] < second[1]) {
        encoded2[enc2Ptr][1] = second[1] - min;
        enc1Ptr++;
      } else {
        enc1Ptr++;
        enc2Ptr++;
      }
    }
    return result;

  }

  @Test
  public void test() {

    int[][] encoded1 = {{2, 2}, {5, 5}, {1, 5}, {2, 5}, {4, 2}, {5, 3}, {1, 2}, {4, 3}, {3, 2},
        {2, 3}};
    int[][] encoded2 = {{1, 1}, {4, 1}, {3, 3}, {5, 3}, {1, 4}, {5, 1}, {4, 1}, {5, 3}, {3, 5},
        {2, 1}, {1, 2}, {3, 1}, {2, 1}, {4, 3}, {3, 1}, {2, 1}};
    findRLEArray(encoded1, encoded2);
  }

  @Test
  public void test1() {

    int[][] encoded1 = {{1, 3},
        {2, 3}};
    int[][] encoded2 = {{6, 3}, {3, 3}};
    findRLEArray(encoded1, encoded2);
  }


}
