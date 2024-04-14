package interview.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;

public class PermutationsII_47 {


  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> permuteUnique(int[] nums) {
    helper(nums, new HashSet<Integer>(), new ArrayList<>());
    return result;
  }

  private void helper(int[] nums, HashSet<Integer> visited, List<Integer> currentList) {
    if (currentList.size() == nums.length && !result.contains(currentList)) {
      result.add(new ArrayList<>(currentList));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (!visited.contains(i)) {
        visited.add(i);
        currentList.add(nums[i]);
        helper(nums, visited, currentList);
        currentList.remove(currentList.size() - 1);
        visited.remove(i);
      }
    }
  }

  @Test
  public void test() {
    int[] nums = {1, 2, 1};
    System.out.println(permuteUnique(nums));
  }
}
