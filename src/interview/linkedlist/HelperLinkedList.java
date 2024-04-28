package interview.linkedlist;

public class HelperLinkedList {


  public ListNode generateLinkedList(Integer[] integers) {

    ListNode head = null;
    ListNode current = null;

    for (int i = 0; i < integers.length; i++) {
      if (head == null) {
        head = new ListNode(integers[i]);
        current = head;
      } else {
        current.next = new ListNode(integers[i]);
        current = current.next;
      }

    }
    return head;
  }


}
