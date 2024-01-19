package interview.stacksandqueues;

//622. Design Circular Queue
public class MyCircularQueue {

  int headIndex;
  int tailIndex;
  int size;
  int[] queue;
  int numOfElements;

  public MyCircularQueue(int k) {
    headIndex = -1;
    tailIndex = 0;
    size = k;
    queue = new int[k];
    numOfElements = 0;
  }

  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }
    headIndex = increaseIndex(headIndex);
    queue[headIndex] = value;
    numOfElements++;
    return true;
  }

  private int increaseIndex(int headIndex) {
    headIndex++;
    if (headIndex == size) {
      headIndex = 0;
    }
    return headIndex;
  }

  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }
    tailIndex = increaseIndex(tailIndex);
    numOfElements--;
    return true;
  }

  public int Front() {
    if (isEmpty()) {
      return -1;
    }
    return queue[tailIndex];
  }

  public int Rear() {
    if (isEmpty()) {
      return -1;
    }
    return queue[headIndex];
  }

  public boolean isEmpty() {
    return numOfElements == 0;
  }

  public boolean isFull() {
    return numOfElements == size;
  }

  public static void main(String[] args) {
    MyCircularQueue myCircularQueue = new MyCircularQueue(3);
    System.out.println(myCircularQueue.enQueue(1)); // return True
    System.out.println(myCircularQueue.enQueue(2)); // return True
    System.out.println(myCircularQueue.enQueue(3)); // return True
    System.out.println(myCircularQueue.enQueue(4)); // return False
    System.out.println(myCircularQueue.Rear());     // return 3
    System.out.println(myCircularQueue.isFull());   // return True
    System.out.println(myCircularQueue.deQueue());  // return True
    System.out.println(myCircularQueue.enQueue(4)); // return True
    System.out.println(myCircularQueue.Rear());     // return 4
  }
}
