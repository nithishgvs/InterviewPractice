package interview.miscellaneous;

import java.util.concurrent.*;

class Worker implements Runnable {

  private final DelayQueue<ScheduledTask> taskQueue;

  public Worker(DelayQueue<ScheduledTask> taskQueue) {
    this.taskQueue = taskQueue;
  }

  @Override
  public void run() {
    while (true) {
      try {
        // Take the next task from the queue, waiting if necessary
        ScheduledTask task = taskQueue.take();
        task.execute();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        break;
      }
    }
  }
}


class ScheduledTask implements Delayed {

  private final long scheduledTime;
  private final Runnable task;

  public ScheduledTask(long delayInMillis, Runnable task) {
    this.scheduledTime = System.currentTimeMillis() + delayInMillis;
    this.task = task;
  }

  @Override
  public long getDelay(TimeUnit unit) {
    long delay = scheduledTime - System.currentTimeMillis();
    return unit.convert(delay, TimeUnit.MILLISECONDS);
  }

  @Override
  public int compareTo(Delayed o) {
    if (this.scheduledTime < ((ScheduledTask) o).scheduledTime) {
      return -1;
    }
    if (this.scheduledTime > ((ScheduledTask) o).scheduledTime) {
      return 1;
    }
    return 0;
  }

  public void execute() {
    task.run();
  }
}


public class Scheduler {

  private final DelayQueue<ScheduledTask> taskQueue = new DelayQueue<>();
  private final ExecutorService executorService;
  private final int workerCount;

  public Scheduler(int workerCount) {
    this.workerCount = workerCount;
    this.executorService = Executors.newFixedThreadPool(workerCount);
    startWorkers();
  }

  public void scheduleTask(long delayInMillis, Runnable task) {
    ScheduledTask scheduledTask = new ScheduledTask(delayInMillis, task);
    taskQueue.offer(scheduledTask);
  }

  private void startWorkers() {
    for (int i = 0; i < workerCount; i++) {
      executorService.execute(new Worker(taskQueue));
    }
  }

  public void shutdown() {
    executorService.shutdown();
    try {
      if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
        executorService.shutdownNow();
      }
    } catch (InterruptedException e) {
      executorService.shutdownNow();
    }
  }

  public static void main(String[] args) {
    Scheduler scheduler = new Scheduler(4); // Create a scheduler with 4 worker threads

    scheduler.scheduleTask(5000, () -> System.out.println("Task 1 executed after 5 seconds"));
    scheduler.scheduleTask(1000, () -> System.out.println("Task 2 executed after 1 second"));
    scheduler.scheduleTask(3000, () -> System.out.println("Task 3 executed after 3 seconds"));

    // Shutdown the scheduler gracefully after some time
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      scheduler.shutdown();
      System.out.println("Scheduler shut down.");
    }));
  }
}

