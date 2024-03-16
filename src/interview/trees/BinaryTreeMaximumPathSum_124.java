package interview.trees;

import org.junit.Test;

public class BinaryTreeMaximumPathSum_124 {


  int maxPath = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    maxPathHelper(root);
    return maxPath;
  }

  private int maxPathHelper(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = Math.max(0, maxPathHelper(root.left));
    int right = Math.max(0, maxPathHelper(root.right));

    maxPath = Math.max(maxPath, root.val + left + right);

    return root.val + Math.max(left, right);
  }


  @Test
  public void test() {
    TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{1, 2, 3});
    maxPathSum(root);
  }

}
