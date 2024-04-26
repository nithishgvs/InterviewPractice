package interview.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {


  List<String> result = new ArrayList<>();

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) {
      return result;
    }

    if (root.left == null && root.right == null) {
      result.add(String.valueOf(root.val));
      return result;
    }

    helper(root.left, String.valueOf(root.val));
    helper(root.right, String.valueOf(root.val));

    return result;
  }

  private void helper(TreeNode root, String tempString) {
    if (root == null) {
      return;
    }

    tempString += "->" + root.val;

    if (root.left == null && root.right == null) {
      result.add(tempString);
      return;
    }

    helper(root.left, tempString);
    helper(root.right, tempString);
  }

}
