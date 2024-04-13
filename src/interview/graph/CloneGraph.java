package interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class CloneGraph {

  class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  Map<Integer, Node> visited = new HashMap<>();

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Node newNode = new Node(node.val);
    visited.put(node.val, newNode);

    for (Node neighbour : node.neighbors) {
      if (!visited.containsKey(neighbour.val)) {
        Node neighNode = cloneGraph(neighbour);
        newNode.neighbors.add(neighNode);
      } else {
        newNode.neighbors.add(visited.get(neighbour.val));
      }
    }
    return newNode;
  }
}
