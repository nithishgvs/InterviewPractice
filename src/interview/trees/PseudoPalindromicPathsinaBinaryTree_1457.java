package interview.trees;

import java.util.HashMap;
import org.junit.Test;

public class PseudoPalindromicPathsinaBinaryTree_1457 {


  public int pseudoPalindromicPaths(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return dfs(root, new HashMap<>());
  }

  private static int dfs(TreeNode root, HashMap<Integer, Integer> hm) {
    if (root == null) {
      return 0;
    }

    // Create a new HashMap for each recursive call to avoid unintended modifications
    HashMap<Integer, Integer> newHm = new HashMap<>(hm);
    newHm.put(root.val, newHm.getOrDefault(root.val, 0) + 1);

    if (root.left == null && root.right == null) {
      int oddCount = 0;
      for (int count : newHm.values()) {
        if (count % 2 != 0) {
          oddCount++;
        }
      }
      return oddCount <= 1 ? 1 : 0;
    }

    int result = 0;
    result += dfs(root.left, newHm);
    result += dfs(root.right, newHm);

    return result;
  }

  @Test
  public void test() {
    TreeNode root = new HelperTree().generateBinaryTree(
        new Integer[]{9, 5, 4, 5, null, 2, 6, 2, 5, null, 8, 3, 9, 2, 3, 1, 1, null, 4, 5, 4, 2, 2,
            6, 4, null, null, 1, 7, null, 5, 4, 7, null, null, 7, null, 1, 5, 6, 1, null, null,
            null, null, 9, 2, null, 9, 7, 2, 1, null, null, null, 6, null, null, null, null, null,
            null, null, null, null, 5, null, null, 3, null, null, null, 8, null, 1, null, null, 8,
            null, null, null, null, 2, null, 8, 7});
    System.out.println(pseudoPalindromicPaths(root));
  }

}
