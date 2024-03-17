package interview.trees;

import org.junit.Test;

public class LowestCommonAncestorBt_1644 {

  int count = 0;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode lcaNode = lca(root, p, q);
    return count == 2 ? lcaNode : null;
  }

  private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {

    if (root == null) {
      return null;
    }

    TreeNode left = lca(root.left, p, q);
    TreeNode right = lca(root.right, p, q);

    if (root == p || root == q) {
      count++;
      return root;
    }

    if (left != null && right != null) {
      return root;
    }

    return left != null ? left : right;
  }

  @Test
  public void test() {
    TreeNode treeNode = new HelperTree()
        .generateBinaryTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
    lowestCommonAncestor(treeNode, treeNode.left, treeNode.left.right.right);
  }
}
