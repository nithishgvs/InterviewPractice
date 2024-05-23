package interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class MinimumNumberofOperationstoMakeArrayEmpty_2870 {


  public int minOperations(int[] nums) {

    int count = 0;

    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (Integer entries : map.values()) {
      if (entries == 1) {
        return -1;
      }
      //Logic is if number is 10 6/3 => 2 and 4/2 =>2 total is 4
      if (entries % 3 == 0) {
        count += entries / 3;
      } else {
        count += entries / 3 + 1;
      }
    }

    return count;
  }

  @Test
  public void test() {
    int[] nums = {14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12};
    System.out.println(minOperations(nums));
  }
}
