package interview.miscellaneous;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<String>> callableList = List.of(new CallableTask("Sai"), new CallableTask("Alekhya"), new CallableTask("Ishitha"));
        List<Future<String>> futureList = executorService.invokeAll(callableList);

        for (Future<String> future : futureList) {
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}
