package interview.stacksandqueues;

import java.util.Stack;
import org.junit.Test;

public class AsteroidCollision_735 {


  public int[] asteroidCollision(int[] asteroids) {

    Stack<Integer> stack = new Stack<>();

    stack.add(asteroids[0]);

    for (int i = 1; i < asteroids.length; i++) {
      //Xor operation of two numbers will determine if two elements are having diff signs
      stack.add(asteroids[i]);
      while (stack.size() > 1 && canCollide(stack)) {
        Integer popped = stack.pop();
        if (Math.abs(stack.peek()) < Math.abs(popped)) {
          stack.pop();
          stack.add(popped);
        } else if (Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
          stack.pop();
        }
      }
    }
    int[] result = new int[stack.size()];

    int index = result.length - 1;

    while (!stack.isEmpty()) {
      result[index] = stack.pop();
      index--;
    }

    return result;

  }


  private boolean canCollide(Stack<Integer> stack) {
    int popped = stack.pop();
    boolean collide = stack.peek() > 0 && popped < 0;
    stack.add(popped);
    return collide;
  }

  @Test
  public void test() {
    int[] asteroids = {-2, -1, 1, 2};
    asteroidCollision(asteroids);
  }

}
