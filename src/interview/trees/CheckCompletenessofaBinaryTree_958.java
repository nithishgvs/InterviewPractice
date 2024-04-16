package interview.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessofaBinaryTree_958 {

  public boolean isCompleteTree(TreeNode root) {
    if (root == null) {
      return false;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    boolean farLeftConditionMet = false;
    while (!queue.isEmpty()) {

      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode polled = queue.poll();
        if (polled == null) {
          farLeftConditionMet = true;
          continue;
        }
        if (polled != null) {
          if (farLeftConditionMet) {
            return false;
          }
          queue.add(polled.left);
          queue.add(polled.right);
        }
      }
    }
    return true;
  }

}
