package interview.miscellaneous;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class HashMapConcurrent {


  ReentrantReadWriteLock reentrantReadWriteLock;
  Map<Integer, String> map;

  public HashMapConcurrent() {
    this.reentrantReadWriteLock = new ReentrantReadWriteLock();
    this.map = new HashMap<>();
  }


  public void put(Integer key, String value) {
    reentrantReadWriteLock.writeLock().lock();
    try {
      map.put(key, value);
    } finally {
      reentrantReadWriteLock.writeLock().unlock();
    }
  }

  public String get(Integer key) {
    reentrantReadWriteLock.readLock().lock();
    try {
      return map.get(key);
    } finally {
      reentrantReadWriteLock.readLock().unlock();
    }
  }

  public static void main(String[] args) throws InterruptedException {

    HashMapConcurrent map = new HashMapConcurrent();
    ExecutorService executor = Executors
        .newFixedThreadPool(5); // Create a thread pool with 5 threads

    // Submit tasks to executor
    for (int i = 0; i < 10; i++) {
      final int key = i;
      executor.submit(() -> {
        String value = "Value" + key;
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + ": Added " + key);
      });
    }

    // Submit tasks to executor for getting values
    for (int i = 0; i < 10; i++) {
      final int key = i;
      executor.submit(() -> {
        String value = map.get(key);
        System.out
            .println(Thread.currentThread().getName() + ": Value for key " + key + ": " + value);
      });
    }

    executor.shutdown(); // Shut down executor
  }
}
