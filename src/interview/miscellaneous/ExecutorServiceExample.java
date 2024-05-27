package interview.miscellaneous;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread implements Runnable {

  int number;

  public MyThread(int number) {
    this.number = number;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName());
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

public class ExecutorServiceExample {


  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    for (int i = 0; i < 10; i++) {
      executor.execute(new MyThread(i));
    }
    executor.shutdown();
  }

}
