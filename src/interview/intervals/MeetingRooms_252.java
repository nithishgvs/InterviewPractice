package interview.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MeetingRooms_252 {

  public boolean canAttendMeetings(int[][] intervals) {
    if (intervals.length == 0) {
      return true;
    }
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    Stack<int[]> stack = new Stack<>();
    stack.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      int[] peek = stack.peek();
      if (peek[1] > intervals[i][0]) {
        return false;
      }
      stack.add(intervals[i]);
    }

    return true;
  }
}
