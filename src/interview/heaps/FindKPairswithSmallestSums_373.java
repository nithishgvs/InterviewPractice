package interview.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.Test;

public class FindKPairswithSmallestSums_373 {


  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

    List<List<Integer>> result = new ArrayList<>();
    if (nums1.length == 0 || nums2.length == 0 || k == 0) {
      return result;
    }
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + a[1]));

    for (int i = 0; i < nums1.length && i < k; i++) {
      minHeap.add(new int[]{nums1[i], nums2[0], 0});
    }

    while (k > 0 && !minHeap.isEmpty()) {
      int[] arr = minHeap.poll();

      int num1 = arr[0];
      int num2 = arr[1];
      int idx = arr[2];

      result.add(Arrays.asList(num1, num2));

      if (idx + 1 < nums2.length) {
        minHeap.add(new int[]{num1, nums2[idx + 1], idx + 1});
      }
      k--;
    }

    return result;
  }


  @Test
  public void test() {
    System.out.println(kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 2));
  }


}
