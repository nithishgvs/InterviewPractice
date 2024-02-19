package interview.miscellaneous;

//Thread states
//New
//Runnable
//Running
//Blocked/Waiting
//Terminated/Dead

import java.util.Hashtable;

class Task1 extends Thread {
    @Override
    public void run() {
        System.out.print("Task 1 started");
        for (int i = 101; i <= 199; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nTask 1 Ended");
    }
}

class Task2 implements Runnable {
    @Override
    public void run() {
        System.out.print("Task 2 started");
        for (int i = 201; i <= 299; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nTask 2 Ended");
    }
}

public class ThreadBasisRunner {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("\nTask1 kicked off");
        Task1 task1 = new Task1();
        task1.start();
        //Wait for task 1 to finish
        task1.join();

        System.out.println("\nTask2 kicked off");
        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.start();
        System.out.println("\n Main Thread finished");
    }
}
