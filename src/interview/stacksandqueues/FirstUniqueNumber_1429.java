package interview.stacksandqueues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FirstUniqueNumber_1429 {


  class FirstUnique {


    Map<Integer, Integer> freqMap;
    Queue<Integer> queue;

    public FirstUnique(int[] nums) {
      queue = new LinkedList<>();
      freqMap = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        add(nums[i]);
      }
    }

    public int showFirstUnique() {

      while (!queue.isEmpty() && freqMap.get(queue.peek()) > 1) {
        queue.poll();
      }

      if (!queue.isEmpty()) {
        return queue.peek();
      }

      return -1;
    }

    public void add(int value) {
      queue.add(value);
      freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
    }
  }

}
