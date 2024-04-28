package interview.trees;

import interview.linkedlist.HelperLinkedList;
import interview.linkedlist.ListNode;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ConvertSortedListtoBinarySearchTree_109 {


  public TreeNode sortedListToBST(ListNode head) {

    List<Integer> list = new ArrayList<>();

    ListNode current = head;

    while (current != null) {
      list.add(current.val);
      current = current.next;
    }

    return helper(list, 0, list.size() - 1);
  }

  private TreeNode helper(List<Integer> list, int low, int high) {

    if (low > high) {
      return null;
    }

    if (low == high) {
      return new TreeNode(list.get(low));
    }

    int mid = low + (high - low) / 2;
    TreeNode root = new TreeNode(list.get(mid));
    root.left = helper(list, low, mid - 1);
    root.right = helper(list, mid + 1, high);
    return root;
  }


  @Test
  public void test() {
    ListNode head = new HelperLinkedList().generateLinkedList(new Integer[]{-10, -3, 0, 5, 9});
    //sortedListToBST(head);
    sortedListToBST(null);
  }
}
