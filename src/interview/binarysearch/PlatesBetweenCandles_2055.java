package interview.binarysearch;

import java.util.Map;
import java.util.TreeMap;

public class PlatesBetweenCandles_2055 {

  public int[] platesBetweenCandles(String s, int[][] queries) {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    int sum = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '*')
        sum++;
      else {
        map.put(i, sum);
      }
    }

    int[] result = new int[queries.length];

    //Here for given query we need to calculate the plates * in the range

    for (int i = 0; i < queries.length; i++) {
      int lowerBound = queries[i][0];
      int higherBound = queries[i][1];

      Integer ceilingKey = map.ceilingKey(lowerBound);
      Integer floorKey = map.floorKey(higherBound);

      if (ceilingKey != null & floorKey != null && ceilingKey < floorKey) {
        result[i] = map.get(floorKey) - map.get(ceilingKey);
      }
    }

    return result;
  }

}
