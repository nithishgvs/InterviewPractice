package interview.linkedlist;

import org.junit.Test;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList_426 {


  Node head = null;
  Node previousNode = null;

  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return null;
    }
    treeToDoublyList(root.left);
    if (previousNode == null) {
      head = root;
    } else {
      root.left = previousNode;
      previousNode.right = root;
    }
    previousNode = root;
    treeToDoublyList(root.right);
    previousNode.right = head;
    head.left = previousNode;
    return head;
  }

  @Test
  public void test1() {
    Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(5);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    treeToDoublyList(root);
  }

  @Test
  public void test2() {
    Node root = new Node(4);
    treeToDoublyList(root);
  }

  @Test
  public void test3() {
    Node root = new Node(2);
    root.left = new Node(1);
    treeToDoublyList(root);
  }
}
