package interview.miscellaneous;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterWithAtomicInteger {

  AtomicInteger integer = new AtomicInteger();

  public int getInteger() {
    return integer.get();
  }

  public void setInteger(AtomicInteger integer) {
    integer.incrementAndGet();
  }
}
