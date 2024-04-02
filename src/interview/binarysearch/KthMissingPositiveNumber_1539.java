package interview.binarysearch;

import org.junit.Test;

public class KthMissingPositiveNumber_1539 {

  //https://www.youtube.com/watch?v=uZ0N_hZpyps
  public int findKthPositive(int[] arr, int k) {

    int l = 0, h = arr.length - 1;

    while (l <= h) {
      int mid = l + (h - l) / 2;
      int missing = arr[mid] - (mid + 1);
      if (missing < k) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }

    return l + k;
  }


  @Test
  public void test() {
    int[] arr = new int[]{1, 2, 3, 4};
    System.out.println(findKthPositive(arr, 2));
  }

  @Test
  public void test3() {
    int[] arr = new int[]{5, 6, 7, 8};
    System.out.println(findKthPositive(arr, 2));
  }

  @Test
  public void test1() {
    int[] arr = new int[]{2, 3, 4, 7, 11};
    System.out.println(findKthPositive(arr, 5));
  }

}
