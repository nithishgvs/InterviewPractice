package interview.miscellaneous;


import java.util.concurrent.*;

class CallableTask implements Callable<String> {

    private String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(1000);
        return "Hello " + name;
    }
}

public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new CallableTask("Ishitha"));
        System.out.println("\nCallable Executed");
        System.out.println(future.get());
        System.out.println("\nMain Completed");
        executorService.shutdown();
    }
}
