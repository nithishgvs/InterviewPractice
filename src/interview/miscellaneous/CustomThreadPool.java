package interview.miscellaneous;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
  private final int numberOfThreads;
  private final WorkerThread[] threads;
  private final BlockingQueue<Runnable> taskQueue;

  public CustomThreadPool(int numberOfThreads) {
    this.numberOfThreads = numberOfThreads;
    this.taskQueue = new LinkedBlockingQueue<>();
    this.threads = new WorkerThread[numberOfThreads];

    for (int i = 0; i < numberOfThreads; i++) {
      threads[i] = new WorkerThread(taskQueue);
      threads[i].start();
    }
  }

  public void submitTask(Runnable task) {
    try {
      taskQueue.put(task);  // This will block if the queue is full
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();  // Restore the interrupted status
    }
  }

  public void shutdown() {
    for (WorkerThread worker : threads) {
      worker.shutdown();
    }
  }

  private static class WorkerThread extends Thread {
    private final BlockingQueue<Runnable> taskQueue;
    private volatile boolean isRunning = true;

    public WorkerThread(BlockingQueue<Runnable> taskQueue) {
      this.taskQueue = taskQueue;
    }

    public void run() {
      while (isRunning) {
        try {
          Runnable task = taskQueue.take();  // This will block if the queue is empty
          task.run();
        } catch (InterruptedException e) {
          // Allow thread to exit if interrupted
          isRunning = false;
        } catch (RuntimeException e) {
          // Log or handle the exception
          e.printStackTrace();
        }
      }
    }

    public void shutdown() {
      isRunning = false;
      this.interrupt();  // Interrupt if waiting
    }
  }

  public static void main(String[] args) {
    CustomThreadPool pool = new CustomThreadPool(3);

    for (int i = 0; i < 10; i++) {
      final int taskId = i;
      pool.submitTask(() -> {
        System.out.println("Executing task " + taskId + " by " + Thread.currentThread().getName());
        try {
          Thread.sleep(1000); // Simulate work
        } catch (InterruptedException e) {
          // Handle interruption
          Thread.currentThread().interrupt();  // Restore the interrupted status
        }
      });
    }

    pool.shutdown();
  }
}

