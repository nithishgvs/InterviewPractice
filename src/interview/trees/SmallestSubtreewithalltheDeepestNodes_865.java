package interview.trees;

import com.sun.source.tree.Tree;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SmallestSubtreewithalltheDeepestNodes_865 {


  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    if (root == null) {
      return null;
    }
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    if (leftDepth == rightDepth) {
      return root;
    } else if (leftDepth > rightDepth) {
      return subtreeWithAllDeepest(root.left);
    } else {
      return subtreeWithAllDeepest(root.right);
    }
  }


  private int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = root.left != null ? maxDepth(root.left) : 0;
    int right = root.right != null ? maxDepth(root.right) : 0;
    return 1 + Math.max(left, right);
  }

  @Test
  public void test() {
    TreeNode root = new HelperTree()
        .generateBinaryTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
    subtreeWithAllDeepest(root);

  }

}
