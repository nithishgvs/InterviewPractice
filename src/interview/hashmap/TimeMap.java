package interview.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
  Map<String, TreeMap<Integer, String>> timeMap;

  public TimeMap() {
    timeMap = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {

    if (!timeMap.containsKey(key)) {
      timeMap.put(key, new TreeMap<>());
    }

    timeMap.get(key).put(timestamp, value);

  }

  public String get(String key, int timestamp) {
    TreeMap<Integer, String> treeMap = timeMap.get(key);
    if (treeMap != null) {
      Integer floorKey = treeMap.floorKey(timestamp);
      if (floorKey != null) {
        return treeMap.get(floorKey);
      }
    }
    return "";
  }
}
