package interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class MissingRanges_163 {


  //Checked solution so practice nxt time
  public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
    List<List<Integer>> res = new ArrayList<>();
    int leftBound = lower;

    for (int i = 0; i < nums.length; i++) {
      if (leftBound != nums[i]) {
        res.add(Arrays.asList(leftBound, nums[i] - 1));
      }
      leftBound = nums[i] + 1;
    }

    if (leftBound <= upper) {
      res.add(Arrays.asList(leftBound, upper));
    }
    return res;
  }

  @Test
  public void test() {
    int[] nums = {0, 1, 3, 50, 75};
    findMissingRanges(nums, 0, 99);
  }

}
