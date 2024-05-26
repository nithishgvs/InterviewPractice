package interview.arrays;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class PathCrossing_1496 {

  public boolean isPathCrossing(String path) {

    Set<String> visited = new HashSet<>();

    int x = 0, y = 0;

    visited.add(x+"|"+y);

    for (int i = 0; i < path.length(); i++) {

      char ch = path.charAt(i);

      switch (ch) {
        case 'N':
          y = y + 1;
          break;
        case 'S':
          y = y - 1;
          break;
        case 'E':
          x = x + 1;
          break;
        case 'W':
          x = x - 1;
          break;
      }

      String currLocation = x + "|" + y;

      if (visited.contains(currLocation)) {
        return true;
      }

      visited.add(currLocation);
    }

    return false;

  }


  @Test
  public void test() {
    System.out.println(isPathCrossing("NESWW"));
  }

}
