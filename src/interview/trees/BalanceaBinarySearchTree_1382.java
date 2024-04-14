package interview.trees;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class BalanceaBinarySearchTree_1382 {


  public TreeNode balanceBST(TreeNode root) {
    List<Integer> inOrderList = new ArrayList<>();
    inOrder(root, inOrderList);
    return helper(inOrderList, 0, inOrderList.size() - 1);
  }

  private TreeNode helper(List<Integer> inOrderList, int low, int high) {
    if (low > high) {
      return null;
    }
    if (low == high) {
      return new TreeNode(inOrderList.get(low));
    }
    int mid = low + (high - low) / 2;
    TreeNode root = new TreeNode(inOrderList.get(mid));
    root.left = helper(inOrderList, low, mid - 1);
    root.right = helper(inOrderList, mid + 1, high);
    return root;
  }

  private void inOrder(TreeNode root, List<Integer> inOrderList) {
    if (root == null) {
      return;
    }
    inOrder(root.left, inOrderList);
    inOrderList.add(root.val);
    inOrder(root.right, inOrderList);
  }

  @Test
  public void test() {
    TreeNode root = new HelperTree()
        .generateBinaryTree(new Integer[]{1, null, 2, null, 3, null, 4, null, null});
    TreeNode res = balanceBST(root);
  }

}
