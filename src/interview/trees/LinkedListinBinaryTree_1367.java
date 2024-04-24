package interview.trees;


public class LinkedListinBinaryTree_1367 {

  //Asked in oracle interview

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public boolean isSubPath(ListNode head, TreeNode root) {

    if (root == null) {
      return false;
    }

    if (dfs(head, root)) {
      return true;
    }

    return isSubPath(head, root.left) || isSubPath(head, root.right);
  }

  private boolean dfs(ListNode head, TreeNode root) {
    if (head == null) {
      return true;
    }

    if (root == null) {
      return false;
    }

    if (head.val != root.val) {
      return false;
    }

    return dfs(head.next, root.left) || dfs(head.next, root.right);
  }

}
