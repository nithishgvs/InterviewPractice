package interview.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import org.junit.Test;

public class InsertInterval_57 {

  public int[][] insert(int[][] intervals, int[] newInterval) {

    int[][] newIntervals = new int[intervals.length + 1][2];

    System.arraycopy(intervals, 0, newIntervals, 0, intervals.length);
    newIntervals[intervals.length] = newInterval;
    Arrays.sort(newIntervals, Comparator.comparingInt(a -> a[0]));

    Stack<int[]> stack = new Stack<>();
    stack.add(newIntervals[0]);

    for (int i = 1; i < newIntervals.length; i++) {
      if (!stack.isEmpty() && !hasNoOverlap(stack.peek(), newIntervals[i])) {
        int[] popped = stack.pop();
        stack.push(new int[]{popped[0], Math.max(newIntervals[i][1], popped[1])});
      } else {
        stack.push(newIntervals[i]);
      }
    }

    int[][] result = new int[stack.size()][2];

    for (int i = result.length - 1; i > -1; i--) {
      int[] popped = stack.pop();
      result[i][0] = popped[0];
      result[i][1] = popped[1];
    }

    return result;

  }


  private boolean hasNoOverlap(int[] peek, int[] interval) {
    return interval[0] - peek[1] > 0;
  }

  @Test
  public void test1() {
    int[][] intervals = {{1, 3}, {6, 9}};
    insert(intervals, new int[]{2, 5});
  }

  @Test
  public void test2() {
    int[][] intervals = {};
    insert(intervals, new int[]{2, 5});
  }

  @Test
  public void test3() {
    int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    insert(intervals, new int[]{4, 8});
  }
}
