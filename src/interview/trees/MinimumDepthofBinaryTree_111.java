package interview.trees;

public class MinimumDepthofBinaryTree_111 {

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return helper(root);
  }

  private int helper(TreeNode root) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }
    return 1 + Math.min(helper(root.left), helper(root.right));
  }
}
