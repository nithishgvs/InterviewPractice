package interview.metapblms;

import java.util.*;

public class CloneGraph {

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

    Map<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        if (visited.containsKey(node.val))
            return node;

        Node newNode = new Node(node.val);
        visited.put(newNode.val, newNode);
        for (Node neighbour : node.neighbors) {
            Node neighNode = cloneGraph(neighbour);
            newNode.neighbors.add(neighNode);
        }

        return newNode;
    }
}
