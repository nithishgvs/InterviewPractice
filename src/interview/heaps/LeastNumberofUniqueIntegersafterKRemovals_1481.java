package interview.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberofUniqueIntegersafterKRemovals_1481 {

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {


        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));


        minHeap.addAll(map.entrySet());

        while (k > 0) {

            Map.Entry<Integer, Integer> polled = minHeap.poll();

            if (polled.getValue() > 1) {
                polled.setValue(polled.getValue() - 1);
                minHeap.add(polled);
            }
            k--;
        }


        return minHeap.size();

    }

    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
    }
}
