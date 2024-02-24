package interview.trees;

import com.sun.source.tree.Tree;

public class DeleteNodeInaBST_450 {


  public TreeNode deleteNode(TreeNode root, int key) {
    //Base case
    if (root == null) {
      return null;
    }

    if (root.val > key) {
      //The node will be in Left sub tree
      root.left = deleteNode(root.left, key);
      return root;
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
      return root;
    }

    if (root.left == null) {
      return root.right;
    } else if (root.right == null) {
      return root.left;
    }

    //Now both children exist for this node and we need to replace this with successor

    TreeNode minNode = root.right;

    while (minNode.left != null) {
      minNode = minNode.left;
    }

    root.val = minNode.val;
    root.right = deleteNode(root.right, minNode.val);

    return root;
  }

}
