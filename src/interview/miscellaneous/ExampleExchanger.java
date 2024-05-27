package interview.miscellaneous;

import java.util.concurrent.Exchanger;

/**
 * Exchanger is a synchronization point at which two threads can exchange objects. Each thread
 * presents some object on entry to the exchange method, matches with the partner thread, and
 * receives its partner's object on return. This class is useful in applications such as pipeline
 * designs, where one thread consumes the output of another thread.
 */
public class ExampleExchanger {

  public static void main(String[] args) {
    Exchanger<String> exchanger = new Exchanger<>();

    // Thread A
    new Thread(() -> {
      String threadAData = "Data from Thread A";
      try {
        // Exchange data with Thread B
        String receivedData = exchanger.exchange(threadAData);
        System.out.println("Thread A received: " + receivedData);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();

    // Thread B
    new Thread(() -> {
      String threadBData = "Data from Thread B";
      try {
        // Exchange data with Thread A
        String receivedData = exchanger.exchange(threadBData);
        System.out.println("Thread B received: " + receivedData);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
  }
}

