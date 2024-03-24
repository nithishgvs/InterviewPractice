package interview.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import org.junit.Test;

public class VerticalOrderTraversalofaBinaryTree_987 {


  class TreeHelper {

    int row;
    int col;
    TreeNode treeNode;

    public TreeHelper(int row, int col, TreeNode treeNode) {
      this.row = row;
      this.col = col;
      this.treeNode = treeNode;
    }
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    TreeMap<Integer, List<TreeHelper>> treeMap = new TreeMap<>();

    Queue<TreeHelper> queue = new ArrayDeque<>();

    queue.add(new TreeHelper(0, 0, root));

    while (!queue.isEmpty()) {

      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeHelper polled = queue.poll();
        if (!treeMap.containsKey(polled.col)) {
          treeMap.put(polled.col, new ArrayList<>());
        }
        treeMap.get(polled.col).add(polled);
        if (polled.treeNode.left != null) {
          queue.add(new TreeHelper(polled.row + 1, polled.col - 1, polled.treeNode.left));
        }

        if (polled.treeNode.right != null) {
          queue.add(new TreeHelper(polled.row + 1, polled.col + 1, polled.treeNode.right));
        }
      }
    }

    for (Integer col : treeMap.keySet()) {
      List<TreeHelper> collection = treeMap.get(col);
      List<Integer> list = new ArrayList<>();
      Collections.sort(collection, (a, b) -> {
        if (a.row == b.row && a.col == b.col) {
          return a.treeNode.val - b.treeNode.val;
        }
        return a.row - b.row;
      });
      collection.forEach(element -> list.add(element.treeNode.val));
      result.add(list);
    }

    return result;

  }


  @Test
  public void test() {
    TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{3, 1, 4, 0, 2, 2});
    verticalTraversal(root);
  }

  @Test
  public void test1() {
    TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    verticalTraversal(root);
  }

}
