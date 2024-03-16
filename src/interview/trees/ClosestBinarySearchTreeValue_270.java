package interview.trees;

import java.util.PriorityQueue;
import org.junit.Test;

public class ClosestBinarySearchTreeValue_270 {

  class TreeHelper {

    int element;
    double diff;

    public TreeHelper(int element, double diff) {
      this.element = element;
      this.diff = diff;
    }
  }


  public int closestValue(TreeNode root, double target) {

    PriorityQueue<TreeHelper> priorityQueue = new PriorityQueue<>((a, b) -> {
      if (a.diff == b.diff) {
        return a.element - b.element;
      }
      return Double.compare(a.diff, b.diff);
    });

    inOrder(root, target, priorityQueue);

    return priorityQueue.poll().element;

  }

  private void inOrder(TreeNode root, double target, PriorityQueue<TreeHelper> priorityQueue) {
    if (root == null) {
      return;
    }
    inOrder(root.left, target, priorityQueue);
    priorityQueue.add(new TreeHelper(root.val, Math.abs(target - root.val)));
    inOrder(root.right, target, priorityQueue);
  }


  @Test
  public void test() {
    TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{4, 2, 5, 1, 3});
    System.out.println(closestValue(root, 3.714286));
  }

}
