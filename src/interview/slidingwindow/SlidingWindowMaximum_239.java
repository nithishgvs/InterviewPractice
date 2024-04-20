package interview.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class SlidingWindowMaximum_239 {

  //https://takeuforward.org/data-structure/sliding-window-maximum/
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n - k + 1];
    int ri = 0;
    // store index
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < nums.length; i++) {

      if (!deque.isEmpty() && deque.peek() <= i - k) {
        deque.poll();
      }

      while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
        deque.pollLast();
      }

      deque.add(i);

      if (i >= k - 1) {
        result[ri++] = nums[deque.peekFirst()];
      }
    }

    return result;
  }


  @Test
  public void test() {
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    maxSlidingWindow(nums, 3);
  }

}
