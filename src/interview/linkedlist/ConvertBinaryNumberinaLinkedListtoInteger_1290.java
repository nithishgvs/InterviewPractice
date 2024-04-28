package interview.linkedlist;

import org.junit.Test;

public class ConvertBinaryNumberinaLinkedListtoInteger_1290 {


  public int getDecimalValue(ListNode head) {

    int result = 0;
    StringBuilder number = new StringBuilder();
    ListNode current = head;
    while (current != null) {
      number.append(current.val);
      current = current.next;
    }

    int idx = 0;
    for (int i = number.length() - 1; i > -1; i--) {
      result += Integer.valueOf(number.charAt(i) - '0') * Math.pow(2, idx);
      idx++;
    }

    return result;
  }

  @Test
  public void test() {

    HelperLinkedList helperLinkedList = new HelperLinkedList();
    ListNode listNode = helperLinkedList
        .generateLinkedList(new Integer[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0});
    System.out.println(getDecimalValue(listNode));
  }

}
