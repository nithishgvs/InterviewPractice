package interview.trees;

public class SumRootToLeafNumbers_129 {

  int result = 0;

  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    helper(root, "");
    return result;
  }

  private void helper(TreeNode root, String currentString) {
    if (root.left == null && root.right == null) {
      //convert currentString to integer
      currentString += root.val;
      covertToInteger(currentString);
      return;
    }

    currentString += root.val;
    if (root.left != null) {
      helper(root.left, currentString);
    }
    if (root.right != null) {
      helper(root.right, currentString);
    }
  }

  private void covertToInteger(String currentString) {
    int sum = 0;
    int power = 0;
    for (int i = currentString.length() - 1; i > -1; i--) {
      sum += Character.getNumericValue(currentString.charAt(i)) * Math.pow(10, power);
      power++;
    }
    result += sum;
  }
}
