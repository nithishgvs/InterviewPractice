package interview.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindLargestValueinEachTreeRow_515 {

  public List<Integer> largestValues(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {

      int size = queue.size();
      PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));
      for (int i = 0; i < size; i++) {
        TreeNode popped = queue.poll();
        maxHeap.add((long) popped.val);
        if (popped.left != null) {
          queue.add(popped.left);
        }
        if (popped.right != null) {
          queue.add(popped.right);
        }
      }
      result.add(maxHeap.peek().intValue());
      maxHeap.clear();
    }

    return result;
  }
}
