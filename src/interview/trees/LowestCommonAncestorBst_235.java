package interview.trees;

import org.junit.Test;

public class LowestCommonAncestorBst_235 {


  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if (root == null) {
      return null;
    }

    if (root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) {
      return root;
    }

    return left != null ? left : right;

  }


  @Test
  public void test() {
    TreeNode root = new HelperTree()
        .generateBinaryTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
    lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
  }

}
