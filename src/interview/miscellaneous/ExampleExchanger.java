package interview.miscellaneous;

import java.util.concurrent.Exchanger;

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

