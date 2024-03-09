package interview.miscellaneous;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterWithLock {


  private int i = 0;

  public int getI() {
    return i;
  }

  Lock lockI = new ReentrantLock();

  public void incrementI() {
    //Get lock
    lockI.tryLock();
    //lockI.lock(); can use this
    i++;
    //Release lock
    lockI.unlock();
  }


}
