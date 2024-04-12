package interview.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_90 {


  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    helper(nums, 0, new ArrayList<Integer>());
    return result;
  }

  private void helper(int[] nums, int index, List<Integer> currentList) {
    if (!result.contains(currentList)) {
      result.add(new ArrayList<>(currentList));
    }
    if (index >= nums.length) {
      return;
    }

    for (int i = index; i < nums.length; i++) {
      currentList.add(nums[i]);
      helper(nums, i + 1, currentList);
      currentList.remove(currentList.size() - 1);
    }
  }
}
