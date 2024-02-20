package interview.trees;

import org.junit.Test;

public class CountGoodNodesInBinaryTree_1448 {


  int goodNodes = 0;

  public int goodNodes(TreeNode root) {
    if (root == null) {
      return goodNodes;
    }
    goodNodesHelper(root, root.val);
    return goodNodes;
  }

  private void goodNodesHelper(TreeNode currentNode, int maxValue) {
    if (currentNode == null) {
      return;
    }
    if (currentNode.val >= maxValue) {
      goodNodes++;
    }
    goodNodesHelper(currentNode.left, Math.max(currentNode.val, maxValue));
    goodNodesHelper(currentNode.right, Math.max(currentNode.val, maxValue));
  }


  @Test
  public void test() {
    System.out.println(
        goodNodes(new HelperTree().generateBinaryTree(new Integer[]{3, 3, null, 4, 2})));
  }

}
