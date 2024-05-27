package interview.miscellaneous;

import java.io.*;

public class TopCommand {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.err.println("Usage: java TopCommand <filename> <numLines>");
      System.exit(1);
    }

    String fileName = args[0];
    int numLines = Integer.parseInt(args[1]);

    try (RandomAccessFile file = new RandomAccessFile(fileName, "r")) {
      long fileSize = file.length();
      long pointer = 0;
      int linesCount = 0;

      StringBuilder output = new StringBuilder();

      // Start reading file from beginning to end
      while (pointer < fileSize && linesCount < numLines) {
        file.seek(pointer);
        char c = (char) file.read();

        if (c == '\n') {
          linesCount++;
        }

        output.append(c);
        pointer++;
      }

      // Display the specified number of lines
      System.out.println(output.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

