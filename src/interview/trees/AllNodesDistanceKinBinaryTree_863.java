package interview.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodesDistanceKinBinaryTree_863 {

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> result = new ArrayList<>();
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    Queue<TreeNode> queue = new LinkedList<>();
    constructParentGraph(target, root, queue, parentMap, null);

    Set<TreeNode> visited = new HashSet<>();

    while (!queue.isEmpty()) {
      int size = queue.size();
      if (k == 0) {
        while (!queue.isEmpty()) {
          result.add(queue.poll().val);
        }
        break;
      }
      for (int i = 0; i < size; i++) {
        TreeNode polled = queue.poll();
        visited.add(polled);
        if (polled.left != null && !visited.contains(polled.left)) {
          queue.add(polled.left);
        }
        if (polled.right != null && !visited.contains(polled.right)) {
          queue.add(polled.right);
        }
        if (parentMap.get(polled) != null && !visited.contains(parentMap.get(polled))) {
          queue.add(parentMap.get(polled));
        }
      }
      k--;
    }

    return result;
  }

  private void constructParentGraph(TreeNode target, TreeNode root, Queue<TreeNode> queue,
      Map<TreeNode, TreeNode> parentMap, TreeNode parentNode) {

    if (root == null) {
      return;
    }
    if (target == root) {
      queue.add(root);
    }

    if (parentNode != null) {
      parentMap.put(root, parentNode);
    }
    constructParentGraph(target, root.left, queue, parentMap, root);
    constructParentGraph(target, root.right, queue, parentMap, root);

  }
}
