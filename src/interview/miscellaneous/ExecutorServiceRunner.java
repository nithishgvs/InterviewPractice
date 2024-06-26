package interview.miscellaneous;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Task extends Thread {

    private int number;

    public Task(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.print("\nTask " + number + " started\n");
        for (int i = number * 100; i <= number * 100 + 99; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nTask " + number + " Ended\n");
    }
}

public class ExecutorServiceRunner {
    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.execute(new Task1());
//        executorService.execute(new Thread(new Task2()));
//        executorService.shutdown();


        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new Task(1));
        executorService.execute(new Task(2));
        executorService.execute(new Task(3));
        executorService.execute(new Task(4));
        executorService.execute(new Task(5));
        executorService.execute(new Task(6));
        executorService.execute(new Task(7));
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("Hello");
        });
        executorService.shutdown();

    }
}
