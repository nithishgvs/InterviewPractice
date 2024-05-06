package interview.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache_460 {


  TreeMap<Integer, DoubleLinkedList> freqMap = new TreeMap<>();

  Map<Integer, DoubleLinkedNode> map = new HashMap<>();

  int minimumFrequency = 0;

  class DoubleLinkedNode {

    int key;
    int value;
    int count;
    DoubleLinkedNode previous;
    DoubleLinkedNode next;
  }


  class DoubleLinkedList {

    DoubleLinkedNode head;
    DoubleLinkedNode tail;

    public DoubleLinkedList() {
      this.head = new DoubleLinkedNode();
      this.tail = new DoubleLinkedNode();
      this.head.next = tail;
      this.tail.previous = head;
    }

    public void addToHead(DoubleLinkedNode doubleLinkedNode) {
      DoubleLinkedNode next = this.head.next;
      next.previous = doubleLinkedNode;
      this.head.next = doubleLinkedNode;
      doubleLinkedNode.previous = this.head;
      doubleLinkedNode.next = next;
    }

    public DoubleLinkedNode removeNode(DoubleLinkedNode doubleLinkedNode) {
      DoubleLinkedNode next = doubleLinkedNode.next;
      DoubleLinkedNode previous = doubleLinkedNode.previous;
      previous.next = next;
      next.previous = previous;
      return doubleLinkedNode;
    }

    public boolean isEmpty() {
      return this.head.next == tail;
    }

    public DoubleLinkedNode removeLast() {
      if (isEmpty()) {
        return null; // list is empty, nothing to remove
      }
      return removeNode(this.tail.previous);
    }

  }


  class LFUCache {

    int capacity;


    public LFUCache(int capacity) {
      this.capacity = capacity;
    }

    public int get(int key) {
      if (capacity == 0 || !map.containsKey(key)) {
        return -1;
      }

      DoubleLinkedNode doubleLinkedNode = map.get(key);
      increaseFrequency(doubleLinkedNode);
      return doubleLinkedNode.value;

    }

    private void increaseFrequency(DoubleLinkedNode doubleLinkedNode) {
      int currentFrequency = doubleLinkedNode.count;
      DoubleLinkedList currentList = freqMap.get(currentFrequency);
      currentList.removeNode(doubleLinkedNode);
      if (currentList.isEmpty()) {
        freqMap.remove(currentFrequency);
        if (currentFrequency == minimumFrequency) {
          minimumFrequency++; // increment the minimum frequency if necessary
        }
      }
      doubleLinkedNode.count++;
      addNodeToFrequencyList(doubleLinkedNode);
    }

    private void addNodeToFrequencyList(DoubleLinkedNode doubleLinkedNode) {
      int newFrequency = doubleLinkedNode.count;
      DoubleLinkedList newList = freqMap.getOrDefault(newFrequency, new DoubleLinkedList());
      newList.addToHead(doubleLinkedNode);
      freqMap.put(newFrequency, newList);
    }


    public void put(int key, int value) {
      if (map.containsKey(key)) {
        DoubleLinkedNode doubleLinkedNode = map.get(key);
        doubleLinkedNode.value = value;
        increaseFrequency(doubleLinkedNode);
        return;
      }

      if (map.size() == capacity) {
        DoubleLinkedList doubleLinkedList = freqMap.get(minimumFrequency);
        DoubleLinkedNode toBeRemoved = doubleLinkedList.removeLast();
        map.remove(toBeRemoved.key);
      }

      DoubleLinkedNode doubleLinkedNode = new DoubleLinkedNode();
      doubleLinkedNode.key = key;
      doubleLinkedNode.value = value;
      doubleLinkedNode.count = 1;
      addNodeToFrequencyList(doubleLinkedNode);
      minimumFrequency = 1;
      map.put(doubleLinkedNode.key, doubleLinkedNode);
    }
  }

  public static void main(String[] args) {
    LFUCache_460 lfuCache = new LFUCache_460();

    LFUCache lfu = lfuCache.new LFUCache(2);

    lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
    lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
    System.out.println(lfu.get(1));      // return 1
    // cache=[1,2], cnt(2)=1, cnt(1)=2
    lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
    // cache=[3,1], cnt(3)=1, cnt(1)=2
    System.out.println(lfu.get(2));      // return -1 (not found)
    System.out.println(lfu.get(3));      // return 3
    // cache=[3,1], cnt(3)=2, cnt(1)=2
    lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
    // cache=[4,3], cnt(4)=1, cnt(3)=2
    System.out.println(lfu.get(1));      // return -1 (not found)
    System.out.println(lfu.get(3));      // return 3
    // cache=[3,4], cnt(4)=1, cnt(3)=3
    System.out.println(lfu.get(4));      // return 4
    // cache=[4,3], cnt(4)=2, cnt(3)=3
  }

}
