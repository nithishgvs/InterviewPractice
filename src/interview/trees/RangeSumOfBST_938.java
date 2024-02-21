package interview.trees;

import com.sun.source.tree.Tree;
import org.junit.Test;

public class RangeSumOfBST_938 {


  int rangeSum = 0;

  public int rangeSumBST(TreeNode root, int low, int high) {

    if (root == null) {
      return 0;
    }

    if (root.val >= low && root.val <= high) {
      rangeSum += root.val;
    }
    rangeSumBST(root.left, low, high);
    rangeSumBST(root.right, low, high);

    return rangeSum;
  }

  @Test
  public void test1() {
    TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{10, 5, 15, 3, 7, null, 18});
    System.out.println(rangeSumBST(root, 7, 15));
  }


}
