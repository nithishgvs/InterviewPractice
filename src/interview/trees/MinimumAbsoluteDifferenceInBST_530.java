package interview.trees;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MinimumAbsoluteDifferenceInBST_530 {


  List<Integer> list = new ArrayList<>();

  private void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }

    inOrder(root.left);
    list.add(root.val);
    inOrder(root.right);

  }


  public int getMinimumDifference(TreeNode root) {
    inOrder(root);
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < list.size() - 1; i++) {
      minDiff = Math.min(minDiff, Math.abs(list.get(i) - list.get(i + 1)));

    }
    return minDiff;
  }

  @Test
  public void test() {
    System.out.println(getMinimumDifference(
        new HelperTree().generateBinaryTree(new Integer[]{1, 0, 48, null, null, 12, 49})));
  }


}
