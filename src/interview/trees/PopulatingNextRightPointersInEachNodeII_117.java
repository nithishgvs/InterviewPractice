package interview.trees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.junit.Test;

public class PopulatingNextRightPointersInEachNodeII_117 {

  class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

  public Node connect(Node root) {

    if (root == null) {
      return null;
    }

    ArrayDeque<Node> queue = new ArrayDeque<>();

    queue.add(root);

    Node prevNode = null;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node currentNode = queue.pop();
        if (currentNode.left != null) {
          queue.add(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.add(currentNode.right);
        }
        if (prevNode != null) {
          prevNode.next = currentNode;
        }
        prevNode = currentNode;
      }
      prevNode = null;
    }
    return root;
  }

}
