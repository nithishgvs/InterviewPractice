package interview.miscellaneous;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;


class Producer implements Runnable {

  BlockingQueue<Integer> linkedBlockingQueue;

  public Producer(BlockingQueue<Integer> linkedBlockingQueue) {
    this.linkedBlockingQueue = linkedBlockingQueue;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        System.out.println("Producer adding: " + i);
        linkedBlockingQueue.put(i); // Use put instead of add
      } catch (InterruptedException ex) {
        System.out.println(ex);
      }
    }
  }
}

class Consumer implements Runnable {

  BlockingQueue<Integer> linkedBlockingQueue;
  private volatile boolean running = true; // Flag to control the loop

  public Consumer(BlockingQueue<Integer> linkedBlockingQueue) {
    this.linkedBlockingQueue = linkedBlockingQueue;
  }

  public void stopConsuming() {
    running = false; // Method to stop the consumer
  }

  @Override
  public void run() {
    while (running) { // Check the flag to control the loop
      try {
        Integer taken = linkedBlockingQueue.take();
        System.out.println("Consumer took: " + taken);
      } catch (InterruptedException ex) {
        System.out.println(ex);
      }
    }
  }
}

public class ProducerConsumerProblem {

  public static void main(String[] args) {
    BlockingQueue<Integer> sharedQueue = new LinkedBlockingDeque<>();

    Producer producer = new Producer(sharedQueue);
    Consumer consumer = new Consumer(sharedQueue);

    ExecutorService executorServiceProducer = Executors.newSingleThreadExecutor();
    ExecutorService executorServiceConsumer = Executors.newSingleThreadExecutor();

    executorServiceConsumer.submit(consumer);
    executorServiceProducer.submit(producer);

    // Some delay before shutting down the threads
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Stop the consumer and shut down the executor services
    consumer.stopConsuming();
    executorServiceConsumer.shutdown();
    executorServiceProducer.shutdown();
  }
}


