package interview.miscellaneous;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableExample implements Callable<String> {

  @Override
  public String call() throws Exception {
    Thread.sleep(1000);
    return "Hello World";
  }
}

public class FutureExample {


  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<String> future = executorService.submit(new CallableExample());
    try {
      // Wait for the task to complete and get the result
      String result = future.get(); // This will block until the result is available
      System.out.println("Result: " + result);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

    executorService.shutdown();

  }


}
