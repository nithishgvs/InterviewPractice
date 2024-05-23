package interview.miscellaneous;

import java.util.concurrent.Semaphore;

class Database {
  private static final int MAX_CONNECTIONS = 5;
  private Semaphore semaphore;

  public Database() {
    this.semaphore = new Semaphore(MAX_CONNECTIONS);
  }

  public void connect() {
    try {
      semaphore.acquire(); // Acquire a permit
      System.out.println("Connected. Available connections: " + semaphore.availablePermits());
      // Logic to establish database connection
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void disconnect() {
    semaphore.release(); // Release a permit
    System.out.println("Disconnected. Available connections: " + semaphore.availablePermits());
    // Logic to close database connection
  }
}

class DatabaseClient extends Thread {
  private Database database;

  public DatabaseClient(Database database) {
    this.database = database;
  }

  @Override
  public void run() {
    database.connect();
    // Perform database operations
    database.disconnect();
  }
}

public class SemaphoreExample {
  public static void main(String[] args) {
    Database database = new Database();

    // Create multiple threads (clients) accessing the database
    for (int i = 0; i < 10; i++) {
      new DatabaseClient(database).start();
    }
  }
}

