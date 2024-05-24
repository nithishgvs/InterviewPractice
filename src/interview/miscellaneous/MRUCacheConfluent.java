package interview.miscellaneous;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MRUCacheConfluent<K, V> {

  private final int capacity;
  private final Map<K, Node<K, V>> cache;
  private final DoublyLinkedList<K, V> list;
  private final ReentrantReadWriteLock lock;

  public MRUCacheConfluent(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>(capacity);
    this.list = new DoublyLinkedList<>();
    this.lock = new ReentrantReadWriteLock();
  }

  public V get(K key) {
    lock.readLock().lock();
    try {
      if (cache.containsKey(key)) {
        Node<K, V> node = cache.get(key);
        list.moveToFront(node);
        return node.value;
      }
      return null;
    } finally {
      lock.readLock().unlock();
    }
  }

  public void put(K key, V value) {
    lock.writeLock().lock();
    try {
      if (cache.containsKey(key)) {
        Node<K, V> node = cache.get(key);
        node.value = value;
        list.moveToFront(node);
      } else {
        if (cache.size() >= capacity) {
          Node<K, V> removedNode = list.removeFromFront();
          if (removedNode != null) {
            cache.remove(removedNode.key);
          }
        }
        Node<K, V> newNode = new Node<>(key, value);
        list.addToFront(newNode);
        cache.put(key, newNode);
      }
    } finally {
      lock.writeLock().unlock();
    }
  }

  private static class Node<K, V> {

    K key;
    V value;
    Node<K, V> prev;
    Node<K, V> next;

    Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  private static class DoublyLinkedList<K, V> {

    private final Node<K, V> head;
    private final Node<K, V> tail;

    DoublyLinkedList() {
      head = new Node<>(null, null);
      tail = new Node<>(null, null);
      head.next = tail;
      tail.prev = head;
    }

    void addToFront(Node<K, V> node) {
      node.next = head.next;
      node.prev = head;
      head.next.prev = node;
      head.next = node;
    }

    void removeNode(Node<K, V> node) {
      Node<K, V> prevNode = node.prev;
      Node<K, V> nextNode = node.next;
      prevNode.next = nextNode;
      nextNode.prev = prevNode;
    }

    void moveToFront(Node<K, V> node) {
      removeNode(node);
      addToFront(node);
    }

    Node<K, V> removeFromFront() {
      if (head.next == tail) {
        return null;
      }
      Node<K, V> node = head.next;
      removeNode(node);
      return node;
    }
  }

  public static void main(String[] args) {
    MRUCacheConfluent<Integer, String> cache = new MRUCacheConfluent<>(3);
    cache.put(1, "one");
    cache.put(2, "two");
    cache.put(3, "three");
    System.out.println(cache.get(1)); // Output: one
    cache.put(4, "four");             // Evicts key 3
    System.out.println(cache.get(3)); // Output: null
    System.out.println(cache.get(2)); // Output: two
    System.out.println(cache.get(4)); // Output: four
  }
}
