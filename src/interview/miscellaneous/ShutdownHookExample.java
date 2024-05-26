package interview.miscellaneous;

public class ShutdownHookExample {

  private static void cleanUpResources() {
    System.out.println("Cleaning uo");
  }


  public static void main(String[] args) {
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.out.println("Shutdown Hook registering");
      cleanUpResources();
    }));

    System.out.println("Application is running...");

    // Simulate some work
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    System.out.println("Application is exiting...");
    // Optionally, trigger JVM shutdown (uncomment to test)
    // System.exit(0);

  }

}
