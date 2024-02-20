package interview.trees;

import org.junit.Test;

public class MaximumDepthOfBinaryTree_104 {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = root.left != null ? maxDepth(root.left) : 0;
    int right = root.right != null ? maxDepth(root.right) : 0;
    return 1 + Math.max(left, right);
  }

  @Test
  public void test1() {
    System.out.println(
        maxDepth(new HelperTree().generateBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
  }

}
