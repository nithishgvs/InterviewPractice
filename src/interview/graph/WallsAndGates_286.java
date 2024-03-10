package interview.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.Test;

public class WallsAndGates_286 {


  public void wallsAndGates(int[][] rooms) {

    Queue<int[]> queue = new ArrayDeque<>();

    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[0].length; j++) {
        if (rooms[i][j] == 0) {
          queue.add(new int[]{i, j, 0});
        }
      }
    }

    while (!queue.isEmpty()) {
      int[] popped = queue.poll();
      int row = popped[0];
      int col = popped[1];
      rooms[row][col] = Math.min(popped[2], rooms[row][col]);
      if (row + 1 < rooms.length && col < rooms[0].length
          && rooms[row + 1][col] > popped[2] + 1) {
        queue.add(new int[]{row + 1, col, popped[2] + 1});
      }
      if (row - 1 > -1 && col < rooms[0].length && rooms[row - 1][col] > popped[2] + 1) {
        queue.add(new int[]{row - 1, col, popped[2] + 1});
      }
      if (row < rooms.length && col + 1 < rooms[0].length
          && rooms[row][col + 1] > popped[2] + 1) {
        queue.add(new int[]{row, col + 1, popped[2] + 1});
      }
      if (row < rooms.length && col - 1 > -1 && rooms[row][col - 1] > popped[2] + 1){
        queue.add(new int[]{row, col - 1, popped[2] + 1});
      }

    }
  }

  @Test
  public void test1() {
    int[][] rooms = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1},
        {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
    wallsAndGates(rooms);
    System.out.println(rooms);
  }

}
