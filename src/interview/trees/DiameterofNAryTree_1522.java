package interview.trees;

import java.util.ArrayList;
import java.util.List;

public class DiameterofNAryTree_1522 {


  class Node {

    public int val;
    public List<Node> children;


    public Node() {
      children = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  int diameter = 0;

  public int diameter(Node root) {
    if (root == null) {
      return diameter;
    }

    dfsHelper(root);
    return diameter;
  }

  private int dfsHelper(Node root) {
    if (root == null || root.children.size() == 0) {
      return 0;
    }
    int maxSize = 0;
    int secondMax = 0;
    for (Node child : root.children) {
      int depth = dfsHelper(child) + 1;
      if (depth > maxSize) {
        secondMax = maxSize;
        maxSize = depth;
      } else if (depth > secondMax) {
        secondMax = depth;
      }
    }
    diameter = Math.max(diameter, maxSize + secondMax);
    return maxSize;
  }
}
