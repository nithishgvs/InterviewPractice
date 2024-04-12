package interview.trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindBottomLeftTreeValue_513 {


  public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int bottomLeft = Integer.MAX_VALUE;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.poll();
        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
        if (i == 0) {
          bottomLeft = current.val;
        }
      }
    }

    return bottomLeft;
  }
}
