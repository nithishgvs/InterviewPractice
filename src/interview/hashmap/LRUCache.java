package interview.hashmap;


import java.util.HashMap;
import java.util.Map;

class DoublyLinkedNode {

  int key;
  int value;
  DoublyLinkedNode previous;
  DoublyLinkedNode next;
}


class LRUCache {

  class DoubleLinkedList {

    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    public DoubleLinkedList() {
      this.head = new DoublyLinkedNode();
      this.tail = new DoublyLinkedNode();
      this.head.next = this.tail;
      this.tail.previous = this.head;
    }

    public void moveNodeToHead(DoublyLinkedNode node) {
      DoublyLinkedNode nextNode = this.head.next;
      this.head.next = node;
      node.previous = this.head;
      nextNode.previous = node;
      node.next = nextNode;
    }

    public void removeFromTail() {
      DoublyLinkedNode node = this.tail.previous;
      DoublyLinkedNode previous = node.previous;
      previous.next = this.tail;
      this.tail.previous = previous;
      map.remove(node.key);
    }

    public void removeNode(DoublyLinkedNode node) {
      DoublyLinkedNode previous = node.previous;
      DoublyLinkedNode next = node.next;
      previous.next = next;
      next.previous = previous;
    }
  }

  Map<Integer, DoublyLinkedNode> map;
  DoubleLinkedList doubleLinkedList;
  int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
    doubleLinkedList = new DoubleLinkedList();
  }

  public int get(int key) {
    DoublyLinkedNode node = map.get(key);
    if (node == null) {
      return -1;
    }
    doubleLinkedList.removeNode(node);
    doubleLinkedList.moveNodeToHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      DoublyLinkedNode node = map.get(key);
      doubleLinkedList.removeNode(node);
      node.value = value;
      doubleLinkedList.moveNodeToHead(node);
    } else {
      if (map.size() == capacity) {
        doubleLinkedList.removeFromTail();
      }
      DoublyLinkedNode node = new DoublyLinkedNode();
      node.key = key;
      node.value = value;
      doubleLinkedList.moveNodeToHead(node);
      map.put(key, node);
    }

  }

  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    System.out.println(lRUCache.get(1));    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    System.out.println(lRUCache.get(2));    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    System.out.println(lRUCache.get(1));    // return -1 (not found)
    System.out.println(lRUCache.get(3));    // return 3
    System.out.println(lRUCache.get(4));    // return 4

  }
}

