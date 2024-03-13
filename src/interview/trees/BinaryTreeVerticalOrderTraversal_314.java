package interview.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal_314 {

  class TreeNodeHelper {

    TreeNode currentNode;
    int index;

    public TreeNodeHelper(TreeNode currentNode, int index) {
      this.currentNode = currentNode;
      this.index = index;
    }
  }


  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Map<Integer, List<Integer>> helperMap = new TreeMap<>();

    Queue<TreeNodeHelper> queue = new ArrayDeque<>();
    queue.add(new TreeNodeHelper(root, 0));

    while (!queue.isEmpty()) {
      TreeNodeHelper treeNodeHelper = queue.poll();
      if (!helperMap.containsKey(treeNodeHelper.index)) {
        helperMap.put(treeNodeHelper.index, new ArrayList<>());
      }
      helperMap.get(treeNodeHelper.index).add(treeNodeHelper.currentNode.val);

      if (treeNodeHelper.currentNode.left != null) {
        queue.add(new TreeNodeHelper(treeNodeHelper.currentNode.left, treeNodeHelper.index - 1));
      }

      if (treeNodeHelper.currentNode.right != null) {
        queue.add(new TreeNodeHelper(treeNodeHelper.currentNode.right, treeNodeHelper.index + 1));
      }
    }

    helperMap.forEach((k, v) -> {
      result.add(v);
    });

    return result;
  }
}
