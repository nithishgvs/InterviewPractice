package interview.heaps;

import interview.linkedlist.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists_23 {

  public ListNode mergeKLists(ListNode[] lists) {

    ListNode head = null;
    ListNode current = null;

    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

    for (ListNode node : lists) {
      ListNode tempCurr = node;
      while (tempCurr != null) {
        minHeap.add(tempCurr);
        tempCurr = tempCurr.next;
      }
    }

    while (!minHeap.isEmpty()) {
      ListNode polled = minHeap.poll();
      polled.next = null;
      if (head == null) {
        head = polled;
        current = head;
      } else {
        current.next = polled;
        current = current.next;
      }
    }

    return head;

  }

}
