package interview.trees;

import org.junit.Test;

public class ValidateBinarySearchTree_98 {


  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    return validBstHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean validBstHelper(TreeNode root, long minValue, long maxValue) {

    if (root == null) {
      return true;
    }

    if (root.val <= minValue || root.val >= maxValue) {
      return false;
    }

    return validBstHelper(root.left, minValue, root.val) && validBstHelper(root.right, root.val,
        maxValue);
  }

  @Test
  public void test1() {
    System.out.println(
        isValidBST(new HelperTree().generateBinaryTree(new Integer[]{5, 4, 6, null, null, 3, 7})));
  }
}
