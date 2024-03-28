package interview.linkedlist;

import org.junit.Test;

public class InsertintoaSortedCircularLinkedList_708 {

  class Node {

    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _next) {
      val = _val;
      next = _next;
    }
  }

  /**
   * @param head
   * @param insertVal
   * @return
   */

  public Node insert(Node head, int insertVal) {
    Node newNode = new Node(insertVal);
    if (head == null) {
      newNode.next = newNode;
      return newNode;
    }
    Node current = head;

    while (true) {
      int currentVal = current.val;
      int nextVal = current.next.val;

      if (currentVal <= insertVal && insertVal <= nextVal) {
        //Insert
        insert(newNode, current);
        break;
      } else if (currentVal > nextVal) {
        //Current is greater than next one we check if the value fits in between
        //Or 5 7 in the list and 1 has to be inserted
        // Current will  be 7 node and insertval 1<7 so it comes after 7 5->7->1
        if (insertVal > currentVal || insertVal < nextVal) {
          //Insert
          insert(newNode, current);
          break;
        }
      } else if (current.next == head) {
        //Reached the end like 1,1,1 scenario or 5 7 in List and 8 is the newNode
        //Insert
        insert(newNode, current);
        break;
      }

      current = current.next;
    }
    return head;
  }

  private void insert(Node newNode, Node current) {
    newNode.next = current.next;
    current.next = newNode;
  }


  @Test
  public void test() {
    Node head1 = new Node(1);
    Node head11 = new Node(1);
    Node head111 = new Node(1);
    head1.next = head11;
    head11.next = head111;
    head111.next = head1;
    insert(head1, 2);
  }

  @Test
  public void test1() {
    Node head1 = new Node(5);
    Node head2 = new Node(7);
    head1.next = head2;
    head2.next = head1;
    insert(head1, 8);
  }

}
