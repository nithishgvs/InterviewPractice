package interview.arrays;

import org.junit.Test;

public class ElementAppearingMoreThanTwentyFivePerInSortedArray_1287 {


  public int findSpecialInteger(int[] arr) {

    int len = arr.length;

    int index = len / 4;

    for (int i = 0; i < arr.length; i++) {
      int newIndex = i + index;

      if (newIndex < arr.length && arr[newIndex] == arr[i]) {
        return arr[i];
      }
    }

    return 0;
  }

  @Test
  public void test() {
    int[] nums = {1,1};
    System.out.println(findSpecialInteger(nums));
  }

}
