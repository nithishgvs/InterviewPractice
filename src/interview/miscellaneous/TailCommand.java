package interview.miscellaneous;

import java.io.*;

public class TailCommand {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.err.println("Usage: java TailCommand <file> <numLines>");
      System.exit(1);
    }

    String fileName = args[0];
    int numLines = Integer.parseInt(args[1]);

    try (RandomAccessFile file = new RandomAccessFile(fileName, "r")) {
      long fileSize = file.length();
      long pointer = fileSize - 1;
      int linesCount = 0;

      StringBuilder tailLines = new StringBuilder();

      // Start reading file from end to beginning
      while (pointer >= 0 && linesCount < numLines) {
        file.seek(pointer);
        char c = (char) file.read();

        if (c == '\n') {
          linesCount++;
        }

        tailLines.insert(0, c);
        pointer--;
      }

      System.out.println(tailLines.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

