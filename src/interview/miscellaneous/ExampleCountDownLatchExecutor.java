package interview.miscellaneous;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A CountDownLatch is a synchronization aid that allows one or more threads to wait until a set of
 * operations being performed in other threads completes. It's initialized with a count, and each
 * thread that needs to wait for the count to reach zero calls the await() method. Threads
 * performing the operations decrement the count by calling the countDown() method.
 */
public class ExampleCountDownLatchExecutor {

  public static void main(String[] args) throws InterruptedException {
    int numberOfWorkers = 3; // Number of worker threads

    // Creating a CountDownLatch with count as numberOfWorkers
    CountDownLatch latch = new CountDownLatch(numberOfWorkers);

    // Creating a fixed-size thread pool with numberOfWorkers threads
    ExecutorService executor = Executors.newFixedThreadPool(numberOfWorkers);

    // Submitting tasks to the executor
    for (int i = 1; i <= numberOfWorkers; i++) {
      executor.submit(new WorkerTask("Worker " + i, latch));
    }

    // Shutdown the executor to prevent new tasks from being submitted
    executor.shutdown();

    // Main thread waits until all worker threads complete their tasks
    latch.await();

    // All tasks are done
    System.out.println("All tasks are done. Main thread continues.");
  }
}

class WorkerTask implements Runnable {

  private final String name;
  private final CountDownLatch latch;

  public WorkerTask(String name, CountDownLatch latch) {
    this.name = name;
    this.latch = latch;
  }

  @Override
  public void run() {
    System.out.println(name + " is performing its task...");
    // Simulating some task
    try {
      Thread.sleep(2000); // Simulating work
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(name + " task is done.");
    // Decrements the count of the latch
    latch.countDown();
  }
}

