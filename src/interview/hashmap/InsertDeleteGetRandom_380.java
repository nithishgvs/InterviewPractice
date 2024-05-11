package interview.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom_380 {


  class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;

    public RandomizedSet() {
      map = new HashMap<>();
      list = new ArrayList<>();
      rand = new Random();
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
      int idx = map.get(val);
      map.put(list.get(list.size() - 1),idx);
      map.remove(val);
      list.set(idx, list.get(list.size() - 1));
      list.remove(list.size() - 1);
      return true;
    }

    public int getRandom() {
      int idx = rand.nextInt(list.size());
      return list.get(idx);
    }
  }

  public static void main(String[] args) {
    InsertDeleteGetRandom_380 obj = new InsertDeleteGetRandom_380();
    RandomizedSet randomizedSet = obj.new RandomizedSet();
    randomizedSet.insert(0);
    randomizedSet.insert(1);
    randomizedSet.remove(0);
    randomizedSet.insert(2);
    randomizedSet.remove(1);
    randomizedSet.getRandom();
  }


}
