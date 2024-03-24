package interview.trees;

import org.junit.Test;

public class ConstructBinaryTreeFromPreInorderTraversals_105 {


  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
  }

  private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart,
      int inEnd) {

    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }

    if (inEnd == inStart) {
      return new TreeNode(inorder[inStart]);
    }
    TreeNode treeNode = new TreeNode(preorder[preStart]);
    int index = findIndex(inorder, preorder[preStart], inStart, inEnd);
    int leftTreeSize = index - inStart;
    treeNode.left = helper(preorder, inorder, preStart + 1, preStart + leftTreeSize, inStart,
        index - 1);
    treeNode.right = helper(preorder, inorder, preStart + leftTreeSize + 1, preEnd, index + 1,
        inEnd);

    return treeNode;


  }

  private int findIndex(int[] inorder, int value, int start, int end) {

    for (int i = start; i <= end; i++) {
      if (inorder[i] == value) {
        return i;
      }
    }
    return -1;
  }


  @Test
  public void test() {
    int[] preorder = {3, 9, 20, 15, 7};
    int[] inorder = {9, 3, 15, 20, 7};
    System.out.println(buildTree(preorder, inorder));
  }


}
