package interview.miscellaneous;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExampleConfluent {
  public static void main(String[] args) {
    String filePath = "path/to/largefile.txt";
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        processLine(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void processLine(String line) {
    // Processing logic here
    System.out.println(line);
  }
}

