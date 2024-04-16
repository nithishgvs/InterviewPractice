package interview.trees;

public class SumofNodeswithEvenValuedGrandparent_1315 {

  int sum = 0;

  public int sumEvenGrandparent(TreeNode root) {
    int[] parentsArray = {-1, -1};
    helper(root, parentsArray);
    return sum;
  }

  private void helper(TreeNode root, int[] parentsArray) {

    if (root == null) {
      return;
    }

    if (parentsArray[0] % 2 == 0) {
      sum += root.val;
    }

    helper(root.left, new int[]{parentsArray[1], root.val});
    helper(root.right, new int[]{parentsArray[1], root.val});
  }
}
