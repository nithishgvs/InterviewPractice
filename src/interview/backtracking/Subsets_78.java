package interview.backtracking;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Subsets_78 {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    helper(nums, 0, new ArrayList<>());
    return result;
  }

  private void helper(int[] nums, int index, List<Integer> integersList) {
    result.add(new ArrayList<>(integersList));
    if (index == nums.length) {
      return;
    }
    for (int i = index; index < nums.length; i++) {
      integersList.add(nums[i]);
      helper(nums, ++index, integersList);
      integersList.remove(integersList.size() - 1);
    }
  }

  @Test
  public void test() {
    subsets(new int[]{1, 2, 3});
  }

}
