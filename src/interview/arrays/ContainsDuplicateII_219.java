package interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII_219 {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> indexMap = new HashMap<>();

    indexMap.put(nums[0], 0);

    for (int i = 1; i < nums.length; i++) {
      if (indexMap.containsKey(nums[i]) && Math.abs(i - indexMap.get(nums[i])) <= k) {
        return true;
      }
      indexMap.put(nums[i], i);
    }

    return false;
  }
}
