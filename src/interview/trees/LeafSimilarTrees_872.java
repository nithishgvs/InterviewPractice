package interview.trees;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class LeafSimilarTrees_872 {


  public boolean leafSimilar(TreeNode root1, TreeNode root2) {

    List<Integer> list1 = new ArrayList<>();
    helper(root1, list1);
    List<Integer> list2 = new ArrayList<>();
    helper(root2, list2);
    return list1.equals(list2);
  }

  private void helper(TreeNode root, List<Integer> list) {

    if (root == null) {
      return;
    }

    helper(root.left, list);

    if (root.left == null && root.right == null) {
      list.add(root.val);
    }
    helper(root.right, list);
  }

  @Test
  public void test1() {
    TreeNode root1 = new HelperTree()
        .generateBinaryTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
    TreeNode root2 = new HelperTree().generateBinaryTree(
        new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8});
    leafSimilar(root1, root2);
  }

}
