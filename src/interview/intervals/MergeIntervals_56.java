package interview.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import org.junit.Test;

public class MergeIntervals_56 {

  public int[][] merge(int[][] intervals) {

    //Sort by 0th index
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    Stack<int[]> stack = new Stack<>();
    stack.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      if (!stack.isEmpty() && !hasNoOverlap(stack.peek(), intervals[i])) {
        int[] popped = stack.pop();
        stack.push(new int[]{popped[0], Math.max(intervals[i][1], popped[1])});
      } else {
        stack.push(intervals[i]);
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
  public void test() {
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] intervals2 = {{1, 4}, {2, 3}};
    merge(intervals2);
  }

}
