package interview.arrays;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class KthMissingPositiveNumber_1539 {


  public int findKthPositive(int[] arr, int k) {

    int number = 1;


    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      while (number < arr[i]) {
        if (list.size() == k) {
          break;
        }
        list.add(number);
        number++;
      }
      number = number + 1;
    }

    while (list.size() < k) {
      list.add(number);
      number++;
    }

    return list.get(k - 1);
  }


  @Test
  public void test() {
    int[] arr = new int[]{1, 2, 3, 4};

    System.out.println(findKthPositive(arr, 2));

  }

}
