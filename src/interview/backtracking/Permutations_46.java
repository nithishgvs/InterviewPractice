package interview.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {


  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    helper(nums, new ArrayList<>());
    return result;
  }

  private void helper(int[] nums, List<Integer> numsList) {
    if (numsList.size() == nums.length) {
      result.add(new ArrayList<>(numsList));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (numsList.contains(nums[i])) {
        continue;
      }
      numsList.add(nums[i]);
      helper(nums, numsList);
      numsList.remove(numsList.size() - 1);
    }
  }
}
