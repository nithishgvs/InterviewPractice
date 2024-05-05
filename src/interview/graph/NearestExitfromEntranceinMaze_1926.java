package interview.graph;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

public class NearestExitfromEntranceinMaze_1926 {


  public int nearestExit(char[][] maze, int[] entrance) {

    int m = maze.length;
    int n = maze[0].length;

    Queue<int[]> queue = new LinkedList<>();
    queue.add(entrance);

    maze[entrance[0]][entrance[1]] = '+';

    int steps = 0;

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    while (!queue.isEmpty()) {

      steps++;

      int size = queue.size();

      for (int i = 0; i < size; i++) {

        int[] polled = queue.poll();

        for (int[] dir : directions) {

          int x = polled[0] + dir[0];
          int y = polled[1] + dir[1];

          if (x < 0 || x >= m || y < 0 || y >= n) {
            continue;
          }

          if (maze[x][y] == '+') {
            continue;
          }

          if (x == 0 || y == 0 || x == m - 1 || y == n - 1) {
            return steps;
          }

          queue.add(new int[]{x, y});

          maze[x][y] = '+';

        }
      }
    }
    return -1;
  }

  @Test
  public void test() {
    char[][] maze = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
    int[] entrance = {1, 0};
    System.out.println(nearestExit(maze, entrance));
  }

}
