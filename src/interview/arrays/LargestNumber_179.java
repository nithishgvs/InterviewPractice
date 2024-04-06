package interview.arrays;

import java.util.Arrays;
import org.junit.Test;

public class LargestNumber_179 {


  public String largestNumber(int[] nums) {

    String[] arr = new String[nums.length];

    if(Arrays.stream(nums).sum()==0){
      return "0";
    }

    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < nums.length; i++) {
      arr[i] = String.valueOf(nums[i]);
    }

    Arrays.sort(arr, (a, b) -> {
      String x = a + b;
      String y = b + a;
      return y.compareTo(x);
    });

    for (String a : arr) {
      stringBuilder.append(a);
    }

    return stringBuilder.toString();

  }

  @Test
  public void test() {
    int[] nums = {3, 30, 34, 5, 9};
    largestNumber(nums);
  }

}
