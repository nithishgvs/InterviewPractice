package interview.miscellaneous;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FileReaderPractice {


  public static void readingFile() throws Exception {
    try (RandomAccessFile randomAccessFile = new RandomAccessFile("file1.txt", "r")) {
      FileChannel channel = randomAccessFile.getChannel();
      long fileSize = channel.size();
      long chunkSize = 1024; // Example: read in 1KB chunks
      long position = 0;

      while (position < fileSize) {
        long remaining = fileSize - position;
        long size = Math.min(chunkSize, remaining);
        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, position, size);

        // Read data from buffer
        byte[] data = new byte[(int) size];
        buffer.get(data);

        // Process the data here
        System.out.println(new String(data, StandardCharsets.UTF_8)); // Example: Print data to console

        position += size; // Move to the next chunk
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws Exception {
    readingFile();
    FileReader fileReader = new FileReader("file1.txt");
    String line;
    try (BufferedReader reader = new BufferedReader(fileReader)) {
      if ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    }
  }
}
