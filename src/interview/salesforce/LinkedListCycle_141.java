package interview.salesforce;

import interview.linkedlist.HelperLinkedList;
import interview.linkedlist.ListNode;
import org.junit.Test;

public class LinkedListCycle_141 {


  public boolean hasCycle(ListNode head) {

    if (head == null || head.next == null) {
      return false;
    }

    ListNode sPtr = head;
    ListNode fPtr = head;

    while (true) {
      sPtr = sPtr.next;
      if (fPtr != null && fPtr.next != null) {
        fPtr = fPtr.next.next;
      } else {
        return false;
      }
      if (sPtr == fPtr) {
        return true;
      }
    }

  }

  @Test
  public void test() {

    HelperLinkedList helperLinkedList = new HelperLinkedList();
    ListNode listNode = helperLinkedList.generateLinkedList(new Integer[]{1, 2});
    hasCycle(listNode);
  }

}
