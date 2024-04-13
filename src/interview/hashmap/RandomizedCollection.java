package interview.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RandomizedCollection {

  // TC: O(1) - O(1) - O(1)
  // SC: O(n)

  List<Integer> list;
  Map<Integer, Set<Integer>> map;

  public RandomizedCollection() {
    list = new ArrayList<>();
    map = new HashMap<>();
  }

  public boolean insert(int val) {
    if (!map.containsKey(val)) {
      map.put(val, new HashSet<>());
    }

    map.get(val).add(list.size());
    list.add(val);

    return map.get(val).size() == 1;
  }

  public boolean remove(int val) {
    if (!map.containsKey(val) || map.get(val).isEmpty()) {
      return false;
    }

    int removeIdx = map.get(val).iterator().next();
    map.get(val).remove(removeIdx);

    int lastElement = list.get(list.size() - 1);
    list.set(removeIdx, lastElement);

    map.get(lastElement).add(removeIdx);
    map.get(lastElement).remove(list.size() - 1);

    list.remove(list.size() - 1);

    return true;
  }

  public int getRandom() {
    int randomIdx = (int) (Math.random() * list.size());
    return list.get(randomIdx);
  }

}
