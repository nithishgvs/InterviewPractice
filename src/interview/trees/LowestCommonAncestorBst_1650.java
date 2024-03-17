package interview.trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class LowestCommonAncestorBst_1650 {

  class Node {

    public int val;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int val) {
      this.val = val;
    }
  }

  public Node lowestCommonAncestor(Node p, Node q) {

    Node parent = p;

    Map<Integer, Node> map = new HashMap();

    while (parent != null) {
      map.put(parent.val, parent);
      parent = parent.parent;
    }

    parent = q;

    while (parent != null && !map.containsKey(parent.val)) {
      parent = parent.parent;
    }

    return map.get(parent.val);

  }

  @Test
  public void test() {

    Node node3 = new Node(3);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    Node node2 = new Node(2);
    Node node7 = new Node(7);
    Node node4 = new Node(4);
    Node node1 = new Node(1);
    Node node0 = new Node(0);
    Node node8 = new Node(8);

    //Parent Mapping

    node6.parent = node5;
    node5.left = node6;

    node7.parent = node2;
    node4.parent = node2;
    node2.left = node7;
    node2.right = node4;
    node2.parent=node5;

    node5.right = node2;

    node3.left = node5;
    node5.parent = node3;

    node0.parent = node1;
    node8.parent = node1;

    node1.left = node8;
    node1.right = node8;

    node1.parent = node3;
    node3.right = node1;

    lowestCommonAncestor(node5, node1);

  }

}
