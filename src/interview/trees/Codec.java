package interview.trees;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Codec {


  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder stringBuilder = new StringBuilder();
    helper(root, stringBuilder);
    return stringBuilder.toString();
  }

  private void helper(TreeNode root, StringBuilder stringBuilder) {
    if (root == null) {
      stringBuilder.append("|");
      stringBuilder.append(",");
      return;
    }
    stringBuilder.append(root.val).append(",");
    helper(root.left, stringBuilder);
    helper(root.right, stringBuilder);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {

    String[] splitted = data.split(",");
    Queue<String> queue = new ArrayDeque<>();
    Arrays.stream(splitted).forEach(split -> queue.add(split));
    return deserializeHelper(queue);
  }

  private TreeNode deserializeHelper(Queue<String> queue) {

    String popped = queue.poll();
    if (popped.equals("|")) {
      return null;
    }

    TreeNode newNode = new TreeNode(Integer.valueOf(popped));

    newNode.left = deserializeHelper(queue);
    newNode.right = deserializeHelper(queue);

    return newNode;
  }

  public static void main(String[] args) {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{4, 2, 5, 1, 3});
    TreeNode root2 = helperTree
        .generateBinaryTree(new Integer[]{2, 1, 3});
    Codec codec = new Codec();
    String string = codec.serialize(root2);
    TreeNode result = codec.deserialize(string);
    System.out.println(result);
  }

}
