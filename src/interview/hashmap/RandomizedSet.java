package interview.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

  List<Integer> list;
  Random random;
  Map<Integer, Integer> map;

  public RandomizedSet() {
    list = new ArrayList<>();
    map = new HashMap<>();
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

  public static void main(String[] args) {
    RandomizedSet randomizedSet = new RandomizedSet();
    System.out.println(randomizedSet.insert(1));
    System.out.println(randomizedSet.remove(2));
    System.out.println(randomizedSet.insert(2));
    System.out.println(randomizedSet.getRandom());
    System.out.println(randomizedSet.remove(1));
    System.out.println(randomizedSet.insert(2));
    System.out.println(randomizedSet.getRandom());
  }
}
