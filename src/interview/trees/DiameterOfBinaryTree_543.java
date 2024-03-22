package interview.trees;

import org.junit.Test;

public class DiameterOfBinaryTree_543 {

  int max = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    helper(root);
    return max;
  }

  private int helper(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = helper(root.left);
    int right = helper(root.right);

    max = Math.max(max, left + right);

    return 1 + Math.max(left, right);
  }


  @Test
  public void test() {
    TreeNode root = new HelperTree().generateBinaryTree(
        new Integer[]{4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null,
            0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2});
    System.out.println(diameterOfBinaryTree(root));
  }

}
