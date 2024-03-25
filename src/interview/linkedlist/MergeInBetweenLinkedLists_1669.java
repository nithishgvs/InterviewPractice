package interview.linkedlist;

import org.junit.Test;

public class MergeInBetweenLinkedLists_1669 {

  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

    ListNode current = list1;
    ListNode prev = null;

    int temp = a;

    while (a != 0) {
      prev = current;
      current = current.next;
      a--;
    }

    b = b - temp;

    while (b != 0) {
      current = current.next;
      b--;
    }

    ListNode secondListCurrent = list2;

    while (secondListCurrent.next != null) {
      secondListCurrent = secondListCurrent.next;
    }

    prev.next = list2;
    secondListCurrent.next = current.next;

    return list1;
  }

  @Test
  public void test() {
    //10,1,13,6,9,5
    ListNode listNode10 = new ListNode(10);
    ListNode listNode1 = new ListNode(1);
    ListNode listNode13 = new ListNode(13);
    ListNode listNode6 = new ListNode(6);
    ListNode listNode9 = new ListNode(9);
    ListNode listNode5 = new ListNode(5);
    listNode10.next = listNode1;
    listNode1.next = listNode13;
    listNode13.next = listNode6;
    listNode6.next = listNode9;
    listNode9.next = listNode5;

    //1000000,1000001,1000002
    ListNode listNode1000000 = new ListNode(1000000);
    ListNode listNode1000001 = new ListNode(1000001);
    ListNode listNode1000002 = new ListNode(1000002);
    listNode1000000.next = listNode1000001;
    listNode1000001.next = listNode1000002;
    mergeInBetween(listNode10, 3, 4, listNode1000000);
  }

}
