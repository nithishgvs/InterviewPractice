package interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import org.junit.Test;

public class KeysandRooms_841 {


  public boolean canVisitAllRooms(List<List<Integer>> rooms) {

    boolean[] visited = new boolean[rooms.size()];
    visited[0] = true;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.addAll(rooms.get(0));

    while (!queue.isEmpty()) {
      Integer currRoom = queue.poll();
      if (!visited[currRoom]) {
        visited[currRoom] = true;
        queue.addAll(rooms.get(currRoom));
      }
    }

    for (int i = 0; i < visited.length; i++) {
      if (!visited[i]) {
        return false;
      }
    }

    return true;
  }


  @Test
  public void test() {
    List<List<Integer>> rooms = new ArrayList<>();
    rooms.add(Arrays.asList(1));
    rooms.add(Arrays.asList(2));
    rooms.add(Arrays.asList(3));
    rooms.add(Arrays.asList());
    System.out.println(canVisitAllRooms(rooms));
  }
}
