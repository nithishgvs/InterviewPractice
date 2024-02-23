package interview.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  private class DoublyLinkedNode {

    private int key;
    private int value;
    private DoublyLinkedNode nextNode;
    private DoublyLinkedNode previousNode;
  }

  DoublyLinkedNode head;
  DoublyLinkedNode tail;
  Map<Integer, DoublyLinkedNode> cache;
  int size;
  int maxCapacity;


  public LRUCache(int capacity) {
    cache = new HashMap<>();
    size = 0;
    maxCapacity = capacity;
    head = new DoublyLinkedNode();
    tail = new DoublyLinkedNode();
    head.nextNode = tail;
    tail.previousNode = head;
  }

  public int get(int key) {
    DoublyLinkedNode doublyLinkedNode = cache.get(key);
    if (doublyLinkedNode != null) {
      moveToHead(doublyLinkedNode);
      return doublyLinkedNode.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    DoublyLinkedNode doublyLinkedNode = cache.get(key);
    if (doublyLinkedNode == null) {
      //Node is not in cache
      //Insert in the map & add it to the head of the linkedlist
      doublyLinkedNode = new DoublyLinkedNode();
      doublyLinkedNode.key = key;
      doublyLinkedNode.value = value;
      size++;
      addToHead(doublyLinkedNode);
      cache.put(key, doublyLinkedNode);
      if (size > maxCapacity) {
        removeNodeFromTail();
        maxCapacity--;
      }
    } else {
      doublyLinkedNode.value = value;
      cache.put(key, doublyLinkedNode);
      moveToHead(doublyLinkedNode);
    }
  }

  private void removeNodeFromTail() {
    DoublyLinkedNode lastNode = this.tail.previousNode;
    DoublyLinkedNode lastButOne = lastNode.previousNode;
    lastButOne.nextNode = this.tail;
    this.tail.previousNode = lastButOne;
    cache.remove(lastNode.key);
  }

  private void addToHead(DoublyLinkedNode doublyLinkedNode) {
    DoublyLinkedNode nextNode = this.head.nextNode;
    nextNode.previousNode = doublyLinkedNode;
    doublyLinkedNode.previousNode = this.head;
    this.head.nextNode = doublyLinkedNode;
    doublyLinkedNode.nextNode = nextNode;
  }

  private void moveToHead(DoublyLinkedNode doublyLinkedNode) {
    //First remove the node from the list and add to the head
    removeNodeFromList(doublyLinkedNode);
    addToHead(doublyLinkedNode);
  }

  private void removeNodeFromList(DoublyLinkedNode doublyLinkedNode) {
    DoublyLinkedNode previousNode = doublyLinkedNode.previousNode;
    DoublyLinkedNode nextNode = doublyLinkedNode.nextNode;
    previousNode.nextNode = nextNode;
    nextNode.previousNode = previousNode;
  }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1, 1);
    lruCache.put(2, 2);
    System.out.println(lruCache.get(1));
    lruCache.put(3, 3);
    System.out.println(lruCache.get(2));
    lruCache.put(4, 4);
    System.out.println(lruCache.get(1));
    System.out.println(lruCache.get(3));
    System.out.println(lruCache.get(4));
  }

}