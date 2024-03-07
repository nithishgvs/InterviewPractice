package interview.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII_253 {

  public int minMeetingRooms(int[][] intervals) {
    if (intervals.length == 0) {
      return 0;
    }
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    priorityQueue.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      if (!priorityQueue.isEmpty() && priorityQueue.peek()[1] <= intervals[i][0]) {
        priorityQueue.poll();
      }
      priorityQueue.add(intervals[i]);
    }

    return priorityQueue.size();
  }

}
