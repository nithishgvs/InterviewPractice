package interview.stacksandqueues;

import java.util.Arrays;
import java.util.Stack;
import org.junit.Test;

public class CarFleet_853 {

  public int carFleet(int target, int[] position, int[] speed) {
    //https://www.youtube.com/watch?v=Pr6T-3yB9RM

    int[][] combo = new int[position.length][2];
    Stack<Double> stack = new Stack<>();

    for (int i = 0; i < position.length; i++) {
      combo[i][0] = position[i];
      combo[i][1] = speed[i];
    }

    Arrays.sort(combo, (a, b) -> b[0] - a[0]);

    for (int i = 0; i < combo.length; i++) {
      double timeTaken = (double) (target - combo[i][0]) / combo[i][1];
      if (!stack.isEmpty() && stack.peek() >= timeTaken) {
        continue;
      }
      stack.add(timeTaken);
    }
    return stack.size();

  }


  @Test
  public void test() {
    int[] position = {10, 8, 0, 5, 3};
    int[] speed = {2, 4, 1, 1, 3};

    System.out.println(carFleet(12, position, speed));
  }

  @Test
  public void test2() {
    int[] position = {6, 8};
    int[] speed = {3, 2};

    System.out.println(carFleet(10, position, speed));
  }

}
