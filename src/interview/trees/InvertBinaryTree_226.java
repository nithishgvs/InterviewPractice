package interview.trees;

import org.junit.Test;

public class InvertBinaryTree_226 {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    root.right = left;
    root.left = right;
    return root;
  }

  @Test
  public void test1() {
    invertTree(new HelperTree().generateBinaryTree(new Integer[]{4, 2, 7, 1, 3, 6, 9}));
  }

}
