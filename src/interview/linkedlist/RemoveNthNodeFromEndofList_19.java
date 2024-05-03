package interview.linkedlist;

import org.junit.Test;

public class RemoveNthNodeFromEndofList_19 {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    //https://www.youtube.com/watch?v=XVuQxVej6y8
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode right = head;
    ListNode left = dummy;

    while (n > 0 && right != null) {
      right = right.next;
      n--;
    }

    //If right pointer moves ahead by N nodes and the left pointer starts from the dummy the gap between them is N and by the time right pointer reaches end we are at the N-1 node

    while (right != null) {
      left = left.next;
      right = right.next;
    }

    left.next = left.next.next;
    return dummy.next;
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
