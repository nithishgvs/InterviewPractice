package interview.backtracking;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Subsets_78 {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    helper(new ArrayList<>(), nums, 0, result);
    return result;
  }

  private void helper(List<Integer> currentList, int[] nums, int index,
      List<List<Integer>> result) {
    result.add(new ArrayList<>(currentList));
    for (int i = index; i < nums.length; i++) {
      currentList.add(nums[i]);
      helper(currentList, nums, i + 1, result);
      currentList.remove(currentList.size() - 1);
    }
  }

  @Test
  public void test() {
    subsets(new int[]{1, 2, 3});
  }

}
