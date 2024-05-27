package interview.miscellaneous;

import java.util.concurrent.*;

public class CachedThreadPoolExample {
  public static void main(String[] args) {
    // Create a cached thread pool
    ExecutorService executor = Executors.newCachedThreadPool();

    // Submit tasks to the thread pool
    for (int i = 0; i < 10; i++) {
      final int taskId = i;
      executor.submit(() -> {
        System.out.println("Task " + taskId + " executed by thread: " + Thread.currentThread().getName());
      });
    }

    // Shutdown the executor service
    executor.shutdown();
  }
}