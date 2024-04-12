package interview.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {


  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    helper(new ArrayList<>(), candidates, target, 0);
    return result;
  }

  private void helper(List<Integer> currentList, int[] candidates, int target, int index) {
    if (target == 0) {
      result.add(new ArrayList<>(currentList));
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      if (i > index && candidates[i - 1] == candidates[i]) {
        continue;
      }
      if (candidates[i] <= target) {
        currentList.add(candidates[i]);
        helper(currentList, candidates, target - candidates[i], i + 1);
        currentList.remove(currentList.size() - 1);
      }
    }
  }
}
