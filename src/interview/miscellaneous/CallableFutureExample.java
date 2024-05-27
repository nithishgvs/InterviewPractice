package interview.miscellaneous;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SumIntegerCallable implements Callable<Integer> {

  int number;

  public SumIntegerCallable(Integer number) {
    this.number = number;
  }

  @Override
  public Integer call() {
    Integer sum = 0;

    for (int i = 0; i < number; i++) {
      sum += i;
    }
    return sum;
  }
}

public class CallableFutureExample {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    for (int i = 0; i < 10; i++) {
      Future<Integer> integerFuture = executorService.submit(new SumIntegerCallable(i));
      System.out.println("Result: " + integerFuture.get());
    }

    try {
      Thread.sleep(100);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }

    executorService.shutdown();
  }
}
