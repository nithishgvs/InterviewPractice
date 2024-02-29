package interview.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
  List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    helper(candidates, target, 0, new ArrayList<>());
    return result;
  }

  private void helper(int[] candidates, int target, int index, List<Integer> currentList) {
    if (target < 0) {
      return;
    } else if (target == 0) {
      result.add(new ArrayList<>(currentList));
    }

    for (int i = index; i < candidates.length; i++) {
      if (target < candidates[i]) continue;
      currentList.add(candidates[i]);
      helper(candidates, target - candidates[i], i, currentList);
      currentList.remove(currentList.size() - 1);

    }
  }
}
