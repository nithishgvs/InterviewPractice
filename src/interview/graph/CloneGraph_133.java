package interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

class Node {

  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

public class CloneGraph_133 {

  Map<Integer, Node> visited = new HashMap<>();

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Node newNode = new Node(node.val);
    visited.put(node.val, newNode);

    for (Node adjacent : node.neighbors) {
      if (!visited.containsKey(adjacent.val)) {
        Node currentNode = cloneGraph(adjacent);
        newNode.neighbors.add(currentNode);
      } else {
        newNode.neighbors.add(visited.get(adjacent.val));
      }
    }
    return newNode;

  }

  @Test
  public void test() {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    node1.neighbors = List.of(node2, node4);
    node2.neighbors = List.of(node1, node3);
    node3.neighbors = List.of(node2, node4);
    node4.neighbors = List.of(node1, node3);
    Node newNode = cloneGraph(node1);
    System.out.println(newNode);
  }

}
