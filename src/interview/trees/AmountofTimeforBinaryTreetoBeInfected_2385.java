package interview.trees;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;

public class AmountofTimeforBinaryTreetoBeInfected_2385 {


  public int amountOfTime(TreeNode root, int start) {

    int totalTime = 0;

    Map<TreeNode, TreeNode> parentGraph = new HashMap<>();

    Queue<TreeNode> queue = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();

    constructParentGraph(root, null, start, parentGraph, queue);

    while (!queue.isEmpty()) {

      int size = queue.size();

      for (int i = 0; i < size; i++) {

        TreeNode treeNode = queue.poll();
        visited.add(treeNode.val);

        if (treeNode.left != null && !visited.contains(treeNode.left.val)) {
          queue.add(treeNode.left);
        }
        if (treeNode.right != null && !visited.contains(treeNode.right.val)) {
          queue.add(treeNode.right);
        }

        if (parentGraph.get(treeNode) != null && !visited.contains(parentGraph.get(treeNode).val)) {
          queue.add(parentGraph.get(treeNode));
        }
      }
      totalTime++;
    }

    return totalTime - 1;

  }

  private void constructParentGraph(TreeNode root, TreeNode parent, int start,
      Map<TreeNode, TreeNode> parentGraph, Queue<TreeNode> queue) {
    if (parent != null) {
      parentGraph.put(root, parent);
    }

    if (root.val == start) {
      queue.add(root);
    }

    if (root.left != null) {
      constructParentGraph(root.left, root, start, parentGraph, queue);
    }
    if (root.right != null) {
      constructParentGraph(root.right, root, start, parentGraph, queue);
    }
  }


  @Test
  public void test() {
    TreeNode root = new HelperTree()
        .generateBinaryTree(new Integer[]{1, 5, 3, null, 4, 10, 6, 9, 2});
    amountOfTime(root, 3);
  }


}
