package interview.trees;

public class BalancedBinaryTree_110 {

  boolean balanced = true;

  public boolean isBalanced(TreeNode root) {
    helper(root);
    return balanced;
  }

  private int helper(TreeNode root) {
    if (balanced) {
      if (root == null) {
        return 1;
      }

      int leftTreeHeight = helper(root.left);
      int rightTreeHeight = helper(root.right);

      if (Math.abs(leftTreeHeight - rightTreeHeight) > 1) {
        balanced = false;
      }

      return 1 + Math.max(leftTreeHeight, rightTreeHeight);
    }
    return Integer.MAX_VALUE;
  }

}
