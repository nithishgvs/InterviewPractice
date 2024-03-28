package interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI_496 {

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> indexMap = new HashMap<>();

    int[] result = new int[nums1.length];

    for (int i = 0; i < nums2.length; i++) {
      indexMap.put(nums2[i], i);
    }

    for (int i = 0; i < nums1.length; i++) {
      int index = indexMap.get(nums1[i]);
      index++;
      result[i] = -1;

      while (index < nums2.length) {
        if (nums2[index] > nums1[i]) {
          result[i] = nums2[index];
          break;
        }
        index++;
      }
    }
    return result;
  }
}
