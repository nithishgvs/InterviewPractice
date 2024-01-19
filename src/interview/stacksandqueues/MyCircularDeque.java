package interview.stacksandqueues;

//641. Design Circular Deque
//https://www.happycoders.eu/algorithms/implement-deque-using-array/
public class MyCircularDeque {

  int headIndex;
  int tailIndex;
  int[] queue;
  int size = 0;
  int numOfElements;


  public MyCircularDeque(int k) {
    tailIndex = k / 2;
    headIndex = k / 2;
    queue = new int[k];
    size = k;
  }

  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }
    headIndex = decreaseIndex(headIndex);
    queue[headIndex] = value;
    numOfElements++;
    return true;
  }

  private int decreaseIndex(int index) {
    index--;

    if (index < 0) {
      index = size - 1;
    }
    return index;
  }

  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }
    queue[tailIndex] = value;
    tailIndex = increaseIndex(tailIndex);
    numOfElements++;
    return true;
  }

  private int increaseIndex(int index) {
    index++;
    if (index == size) {
      index = 0;
    }
    return index;
  }

  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }
    headIndex = increaseIndex(headIndex);
    numOfElements--;
    return true;
  }

  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }
    tailIndex = decreaseIndex(tailIndex);
    numOfElements--;
    return true;
  }

  public int getFront() {
    if (isEmpty()) {
      return -1;
    }
    return queue[headIndex];
  }

  public int getRear() {
    if (numOfElements == 0) {
      return -1;
    }
    return queue[decreaseIndex(tailIndex)];
  }

  public boolean isEmpty() {
    return numOfElements == 0;
  }

  public boolean isFull() {
    return size == numOfElements;
  }

  public static void main(String[] args) {
//    MyCircularDeque myCircularDeque = new MyCircularDeque(3);
//    System.out.println(myCircularDeque.insertLast(1));  // return True
//    System.out.println(myCircularDeque.insertLast(2));  // return True
//    System.out.println(myCircularDeque.insertFront(3)); // return True
//    System.out.println(myCircularDeque.insertFront(4)); // return False, the queue is full.
//    System.out.println(myCircularDeque.getRear());      // return 2
//    System.out.println(myCircularDeque.isFull());       // return True
//    System.out.println(myCircularDeque.deleteLast());   // return True
//    System.out.println(myCircularDeque.insertFront(4)); // return True
//    System.out.println(myCircularDeque.getFront());     // return 4
    MyCircularDeque myCircularDeque = new MyCircularDeque(5);
    System.out.println(myCircularDeque.insertFront(7));  // return True
    System.out.println(myCircularDeque.insertLast(0));  // return True
    System.out.println(myCircularDeque.getFront());
    System.out.println(myCircularDeque.insertLast(3)); // return True
    System.out.println(myCircularDeque.getFront());
    System.out.println(myCircularDeque.insertFront(9)); // return False, the queue is full.
    System.out.println(myCircularDeque.getRear());      // return 2
    System.out.println(myCircularDeque.getFront());
    System.out.println(myCircularDeque.getFront());// return True
    System.out.println(myCircularDeque.deleteLast());   // return True
    System.out.println(myCircularDeque.getRear());     // return 4
  }

}
