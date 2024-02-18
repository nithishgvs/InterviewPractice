package interview.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import org.junit.Test;

public class NonOverlappingIntervals_435 {

  public int eraseOverlapIntervals(int[][] intervals) {
    //If there is an overlap remove interval with larger end time
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    Stack<int[]> stack = new Stack<>();
    stack.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      if (!stack.isEmpty() && hasOverlap(stack.peek(), intervals[i])) {
        int[] popped = stack.pop();
        stack.push(new int[]{popped[0], Math.min(popped[1], intervals[i][1])});
      } else {
        stack.push(intervals[i]);
      }
    }

    return intervals.length - stack.size();
  }

  private boolean hasOverlap(int[] peek, int[] interval) {
    int front = Math.max(peek[0], interval[0]);
    int back = Math.min(peek[1], interval[1]);
    return back - front > 0;
  }


  @Test
  public void test1() {
    System.out.println(eraseOverlapIntervals(new int[][]{{0, 1}, {3, 4}, {1, 2}}));
  }


  @Test
  public void test2() {
    System.out.println(eraseOverlapIntervals(new int[][]{{1, 11}, {11, 22}, {1, 100}, {2, 12}}));
  }
}
