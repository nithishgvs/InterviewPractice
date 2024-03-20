package interview.arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {

  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums.length == 0) {
      return result;
    }
    int lowerBound = 0;

    int num = nums[lowerBound];

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > num) {
        if (nums[lowerBound] != nums[i - 1]) {
          result.add(nums[lowerBound] + "->" + nums[i - 1]);
        } else {
          result.add(nums[lowerBound] + "");
        }
        lowerBound = i;
        num = nums[i] + 1;
      } else {
        num = num + 1;
      }
    }

    if (lowerBound == nums.length - 1) {
      result.add(nums[lowerBound] + "");
    } else {
      result.add(nums[lowerBound] + "->" + nums[nums.length - 1]);
    }

    return result;

  }

}
