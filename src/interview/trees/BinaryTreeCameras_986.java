package interview.trees;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreeCameras_986 {


  int cameras = 0;
  Set<TreeNode> visited = new HashSet<>();

  public int minCameraCover(TreeNode root) {
    //https://www.youtube.com/watch?v=2Gh5WPjAgJk
    if (root == null) {
      return 0;
    }

    //Last row will have the left and right subtrees as null
    visited.add(null);
    dfs(root, null);
    return cameras;

  }

  private void dfs(TreeNode currNode, TreeNode parent) {
    if (currNode == null) {
      return;
    }

    dfs(currNode.left, currNode);
    dfs(currNode.right, currNode);

    //Parent is null and node is convered (root)
    //Any of its left and right children are not visited
    if (parent == null && !visited.contains(currNode) || !visited.contains(currNode.left)
        || !visited.contains(currNode.right)) {
      visited.add(parent);
      visited.add(currNode);
      visited.add(currNode.left);
      visited.add(currNode.right);
      cameras++;
    }
  }
}
