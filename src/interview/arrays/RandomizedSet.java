package interview.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {


  Map<Integer, Integer> map;
  List<Integer> list;

  Random random;

  public RandomizedSet() {
    map = new HashMap<>();
    list = new ArrayList<>();
    random = new Random();
  }

  public boolean insert(int val) {

    if (map.containsKey(val)) {
      return false;
    }
    map.put(val, list.size());
    list.add(val);
    return true;
  }

  public boolean remove(int val) {
    if (!map.containsKey(val)) {
      return false;
    }

    int index = map.get(val);
    map.put(list.get(list.size() - 1), index);
    map.remove(val);
    list.set(index, list.get(list.size() - 1));
    list.remove(list.size() - 1);
    return true;
  }

  public int getRandom() {
    int index = random.nextInt(list.size());
    return list.get(index);
  }
}
