package interview.trees;

public class FlattenBinaryTreetoLinkedList_114 {


  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    flattenHelper(root);
  }

  private TreeNode flattenHelper(TreeNode currentNode) {
    //Leaf Node
    if (currentNode.left == null && currentNode.right == null) {
      return currentNode;
    }
    TreeNode left = null;
    TreeNode right = null;
    if (currentNode.left != null) {
      left = flattenHelper(currentNode.left);
      currentNode.left = null;
    }
    if (currentNode.right != null) {
      right = flattenHelper(currentNode.right);
      currentNode.right = null;
    }
    if (left != null) {
      currentNode.right = left;
    }
    if (right != null) {
      TreeNode current = currentNode;
      while (current.right != null) {
        current = current.right;
      }
      current.right = right;
    }
    return currentNode;
  }

}
