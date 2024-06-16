package interview.metapblms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (int[] interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek()[1] <= interval[0]) {
                minHeap.poll();
            }
            minHeap.add(interval);
        }

        return minHeap.size();
    }
}
