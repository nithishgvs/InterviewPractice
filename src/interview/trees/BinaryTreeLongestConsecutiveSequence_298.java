package interview.trees;

public class BinaryTreeLongestConsecutiveSequence_298 {


  int maxLength = 0;

  public int longestConsecutive(TreeNode root) {

    helper(root, Integer.MAX_VALUE);

    return 1 + maxLength;

  }


  private int helper(TreeNode root, int neededValue) {

    if (root == null) {
      return 0;
    }

    int currMax = 0;
    int left = helper(root.left, root.val + 1);
    int right = helper(root.right, root.val + 1);

    if (root.val == neededValue) {
      currMax = 1 + Math.max(left, right);
    }

    maxLength = Math.max(currMax, maxLength);

    return currMax;

  }
}
