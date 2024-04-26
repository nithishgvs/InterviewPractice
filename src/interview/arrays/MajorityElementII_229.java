package interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII_229 {

  public List<Integer> majorityElement(int[] nums) {
    Arrays.sort(nums);
    int element = nums[0];
    int count = 1;

    List<Integer> result = new ArrayList<>();

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != element) {
        if (count > nums.length / 3) {
          result.add(element);
        }
        count = 1;
        element = nums[i];
      } else {
        count++;
      }
    }

    if (count > nums.length / 3) {
      result.add(nums[nums.length - 1]);
    }

    return result;
  }
}
