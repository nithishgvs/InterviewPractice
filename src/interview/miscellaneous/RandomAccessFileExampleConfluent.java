package interview.miscellaneous;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExampleConfluent {

  public static void main(String[] args) {
    String filePath = "path/to/largefile.txt";
    try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
      // Move to a specific position in the file
      raf.seek(1024); // Move to the 1024th byte
      String line = raf.readLine();
      processLine(line);

      // Read another line from the current position
      line = raf.readLine();
      processLine(line);

      // Move back to the beginning and read the first line
      raf.seek(0);
      line = raf.readLine();
      processLine(line);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void processLine(String line) {
    // Processing logic here
    System.out.println(line);
  }
}

