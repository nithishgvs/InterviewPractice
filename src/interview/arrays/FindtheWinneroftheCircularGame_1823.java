package interview.arrays;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;

public class FindtheWinneroftheCircularGame_1823 {

  public int findTheWinner(int n, int k) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      queue.add(i);
    }

    while (queue.size() != 1) {
      for (int i = 0; i < k; i++) {
        queue.addLast(queue.poll());
      }
      queue.pollLast();
    }

    return queue.poll();
  }


  @Test
  public void test() {
    System.out.println(findTheWinner(5, 2));
  }

}
