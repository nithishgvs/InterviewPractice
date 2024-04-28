package interview.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.Test;

public class Merge3SortedArrays {

  public static int[] merge(int[] A, int[] B, int[] C) {

    int i = 0, j = 0, k = 0;
    int a = 0, b = 0, c = 0;
    List<Integer> list = new ArrayList<>();
    while (a != Integer.MAX_VALUE || b != Integer.MAX_VALUE || c != Integer.MAX_VALUE) {
      a = (i < A.length) ? A[i] : Integer.MAX_VALUE;
      b = (j < B.length) ? B[j] : Integer.MAX_VALUE;
      c = (k < C.length) ? C[k] : Integer.MAX_VALUE;

      int min = Math.min(Math.min(a, b), c);
      if (list.size() == 0 || list.get(list.size() - 1)
          != min) // remove if you want to allow duplicates from the arrays.
      {
        list.add(min);
      }

      if (list.get(list.size() - 1) == a) {
        i++;
      }
      if (list.get(list.size() - 1) == b) // change to else if, if  you want to allow duplicates.
      {
        j++;
      }
      if (list.get(list.size() - 1) == c) {// change to else if, if  you want to allow duplicates.
        k++;
      }
    }
    list.remove(list.size() - 1);//Last elem will be Integer MAX
    return list.stream().mapToInt(Integer::intValue).toArray();
  }


  public static int[] merge2(int[] A, int[] B, int[] C) {

    List<Integer> list = new ArrayList<>();

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int i : A) {
      minHeap.add(i);
    }
    for (int i : B) {
      minHeap.add(i);
    }
    for (int i : C) {
      minHeap.add(i);
    }

    while (!minHeap.isEmpty()) {
      Integer polled = minHeap.poll();
      if (list.size() == 0 || list.get(list.size() - 1) != polled) {
        list.add(polled);
      }
    }

    return list.stream().mapToInt(Integer::intValue).toArray();
  }

  @Test
  public void test() {
    int[] arr1 = {1, 3, 5, 7, 9};
    int[] arr2 = {2, 4, 6, 8};
    int[] arr3 = {3, 5, 7, 9};

    merge2(arr1, arr2, arr3);
  }

}
