package interview.miscellaneous;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Concurrent Reading: We divide the file into chunks based on the number of threads (numThreads).
 * Each thread is responsible for reading a specific chunk of the file concurrently.
 * <p>
 * Executor Service: We use an ExecutorService with a fixed thread pool to manage the concurrent
 * reading tasks. Each thread is responsible for reading a specific chunk of the file.
 * <p>
 * Read Chunk Method: We define a separate method (readChunk) to read a specific chunk of the file.
 * This method is executed concurrently by multiple threads.
 * <p>
 * Mapped Byte Buffer: Each thread creates a MappedByteBuffer to represent the mapped region of the
 * file for its assigned chunk. This allows each thread to read its portion of the file
 * concurrently.
 * <p>
 * Process Data: Each thread processes the data as needed. In this example, we simply print the data
 * to the console, but you can perform any required processing or manipulation of the data here.
 * <p>
 * By reading and processing different parts of the file concurrently using multiple threads, we can
 * improve the overall performance of reading a huge file while optimizing memory usage. Adjust the
 * number of threads based on the available processor cores for optimal performance.
 */

class MemoryOptimizedFileReader {

  // Method to read a huge file while optimizing memory usage
  public void readHugeFile(String filePath) {
    try (RandomAccessFile file = new RandomAccessFile(filePath, "r");
        FileChannel channel = file.getChannel()) {

      long fileSize = channel.size();
      MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);

      // Read data from buffer
      byte[] data = new byte[(int) fileSize];
      buffer.get(data);

      // Process the data here
      System.out.println(new String(data)); // Example: Print data to console

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static class ConcurrentMemoryOptimizedFileReaderConfluent {

    // Method to read a huge file concurrently
    public static void readHugeFileConcurrently(String filePath, int numThreads) {
      try (RandomAccessFile file = new RandomAccessFile(filePath, "r");
          FileChannel channel = file.getChannel()) {

        long fileSize = channel.size();
        long chunkSize =
            (fileSize + numThreads - 1) / numThreads; // Divide the file into chunks for each thread

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
          final long start = i * chunkSize;
          final long end = Math.min(start + chunkSize, fileSize);
          executor.submit(() -> readChunk(filePath, start, end));
        }

        executor.shutdown();

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    // Method to read a specific chunk of the file
    private static void readChunk(String filePath, long start, long end) {
      try (RandomAccessFile file = new RandomAccessFile(filePath, "r");
          FileChannel channel = file.getChannel()) {

        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, start, end - start);

        // Read data from buffer
        byte[] data = new byte[(int) (end - start)];
        buffer.get(data);

        // Process the data here
        System.out.println(new String(data)); // Example: Print data to console

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public static void main(String[] args) {
      // Specify the path to the huge file
      String filePath = "path/to/huge/file.txt";

      // Specify the number of threads for concurrent reading
      int numThreads = Runtime.getRuntime().availableProcessors(); // Use available processor cores

      // Call the method to read the huge file concurrently
      readHugeFileConcurrently(filePath, numThreads);
    }
  }
}

