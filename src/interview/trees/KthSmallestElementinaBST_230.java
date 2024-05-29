package interview.trees;

import org.junit.Test;

public class KthSmallestElementinaBST_230 {


  int count = 0;
  int res;

  public int kthSmallest(TreeNode root, int k) {
    inOrder(root, k);
    return res;
  }

  private void inOrder(TreeNode root, int k) {

    if (root.left != null) {
      inOrder(root.left, k);
    }
    count++;
    if (count == k) {
      res = root.val;
      return;
    }

    if (root.right != null) {
      inOrder(root.right, k);
    }

  }

  @Test
  public void test() {
    TreeNode root = new HelperTree()
        .generateBinaryTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
    System.out.println(kthSmallest(root, 3));
  }

}
