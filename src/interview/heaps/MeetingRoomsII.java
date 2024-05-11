package interview.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Test;

public class MeetingRoomsII {


  public int minMeetingRooms(int[][] intervals) {

    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

    minHeap.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {

      if (!minHeap.isEmpty() && overlap(minHeap.peek(), intervals[i])) {
        minHeap.poll();
      }

      minHeap.add(intervals[i]);
    }

    return minHeap.size();

  }

  private boolean overlap(int[] peek, int[] interval) {
    return peek[1] <= interval[0];
  }

  @Test
  public void test() {
    int[][] intervals = {{13, 15}, {1, 13}, {6, 9}};
    System.out.println(minMeetingRooms(intervals));
  }

}
