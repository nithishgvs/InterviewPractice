package interview.trees;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII_437 {


  int count = 0;
  Map<Long, Integer> sumMap = new HashMap<>();

  public int pathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return 0;
    }

    helper(root, 0l, targetSum);
    return count;
  }

  private void helper(TreeNode root, long prefixSum, int targetSum) {

    if (root == null) {
      return;
    }

    prefixSum += root.val;

    if (sumMap.containsKey(prefixSum - targetSum)) {
      count += sumMap.get(prefixSum - targetSum);
    }

    if (targetSum == prefixSum) {
      count++;
    }

    //Update prefixSum count
    sumMap.put(prefixSum, sumMap.getOrDefault(prefixSum, 0) + 1);

    helper(root.left, prefixSum, targetSum);
    helper(root.right, prefixSum, targetSum);

    //Backtrack by removing the current prefix sum and its count from the hash table.
    sumMap.put(prefixSum, sumMap.get(prefixSum) - 1);
  }
}
