package interview.linkedlist;

import org.junit.Test;

public class RemoveNthNodeFromEndofList_19 {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    int count = 0;
    ListNode current = head;
    while (current != null) {
      current = current.next;
      count++;
    }

    ListNode prev = null;
    current = head;

    if (count == n) {
      return head.next;
    }

    int counter = 0;
    while (counter < count - n) {
      prev = current;
      current = current.next;
      counter++;
    }

    prev.next = current.next;
    return head;
  }

  @Test
  public void test() {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(4);
    ListNode listNode5 = new ListNode(5);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode5;
    removeNthFromEnd(listNode1, 2);
  }

  @Test
  public void test1() {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    removeNthFromEnd(listNode1, 2);
  }

}
