package interview.trees;

import org.junit.Test;

public class SubtreeOfAnotherTree_572 {


  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    String subRootSerialized = serializeTree(subRoot);
    String rootSerialized = serializeTree(root);

    return rootSerialized.contains(subRootSerialized);

  }

  private String serializeTree(TreeNode root) {
    if (root == null) {
      return "null";
    }

    String left = "L" + serializeTree(root.left);
    String right = "R" + serializeTree(root.right);

    return left + root.val + right;
  }

  @Test
  public void test() {
    TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{3, 4, 5, 1, 2});
    TreeNode subRoot = new HelperTree().generateBinaryTree(new Integer[]{4, 1, 2});
    System.out.println(isSubtree(root, subRoot));
  }

  @Test
  public void test2() {
    TreeNode root = new HelperTree()
        .generateBinaryTree(new Integer[]{1, 2, 3});
    TreeNode subRoot = new HelperTree().generateBinaryTree(new Integer[]{1, 2});
    System.out.println(isSubtree(root, subRoot));
  }

}
