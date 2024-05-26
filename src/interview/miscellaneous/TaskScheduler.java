package interview.miscellaneous;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class ScheduledTask implements Delayed {

  private final Runnable task;
  private final long scheduledTime;

  public ScheduledTask(Runnable task, long delay) {
    this.task = task;
    this.scheduledTime = System.currentTimeMillis() + delay;
  }

  @Override
  public long getDelay(TimeUnit unit) {
    long delay = scheduledTime - System.currentTimeMillis();
    return unit.convert(delay, TimeUnit.MILLISECONDS);
  }

  @Override
  public int compareTo(Delayed other) {
    return Long.compare(this.scheduledTime, ((ScheduledTask) other).scheduledTime);
  }

  public void run() {
    task.run();
  }
}

class TaskScheduler {

  private final DelayQueue<ScheduledTask> taskQueue = new DelayQueue<>();
  private final AtomicBoolean running = new AtomicBoolean(true);

  public TaskScheduler() {
    Thread consumerThread = new Thread(this::consumeTasks);
    consumerThread.start();
  }

  public void scheduleTask(Runnable task, long delay) {
    taskQueue.offer(new ScheduledTask(task, delay));
  }

  private void consumeTasks() {
    while (running.get()) {
      try {
        ScheduledTask scheduledTask = taskQueue.take();
        scheduledTask.run();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        break;
      }
    }
  }

  public void shutdown() {
    running.set(false);
    Thread.currentThread().interrupt(); // Interrupt the consumer thread to wake it up
  }

  public static void main(String[] args) {
    TaskScheduler scheduler = new TaskScheduler();

    // Schedule tasks
    scheduler.scheduleTask(() -> System.out.println("Task 1 executed"),
        2000); // Task 1 with 2000ms delay
    scheduler.scheduleTask(() -> System.out.println("Task 2 executed"),
        3000); // Task 2 with 3000ms delay

    // Schedule shutdown after tasks are likely completed
    scheduler.scheduleTask(scheduler::shutdown, 5000); // Shutdown after 5000ms

    // Note: The scheduler will continue running until explicitly shut down.
  }
}

