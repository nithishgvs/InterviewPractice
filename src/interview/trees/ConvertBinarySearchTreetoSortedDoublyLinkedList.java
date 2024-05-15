package interview.trees;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {


  class Node {

    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  }

  Node head = null;
  Node tail = null;

  public Node treeToDoublyList(Node root) {

    helper(root);

    tail.right = root;
    head.left = tail;

    return head;
  }

  private void helper(Node root) {

    if (root == null) {
      return;
    }

    treeToDoublyList(root.left);

    if (head == null) {
      head = root;
    } else {
      tail.right = root;
      root.left = tail;
    }
    tail = root;
    treeToDoublyList(root.right);

  }
}
