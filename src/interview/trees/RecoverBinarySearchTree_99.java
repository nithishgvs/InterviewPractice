package interview.trees;

import org.junit.Test;

public class RecoverBinarySearchTree_99 {


  public void recoverTree(TreeNode root) {

    inOrder(root);
    int temp = first.val;
    first.val = second.val;
    second.val = temp;

  }

  TreeNode previous = null;
  TreeNode first = null;
  TreeNode second = null;

  private void inOrder(TreeNode root) {

    if (root == null) {
      return;
    }
    inOrder(root.left);
    System.out.println(root.val);

    if (previous != null && previous.val > root.val) {
      if (first == null) {
        first = previous;
      }
      second = root;
    }
    previous = root;
    inOrder(root.right);
  }

  @Test
  public void test() {
    TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{1, 3, null, null, 2});
    TreeNode root2 = new HelperTree().generateBinaryTree(new Integer[]{3, 1, null, null, 2});
    recoverTree(root);
  }

}
