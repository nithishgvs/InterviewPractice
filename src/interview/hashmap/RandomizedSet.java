package interview.hashmap;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {

  Set set;
  Random random;

  public RandomizedSet() {
    set = new HashSet();
    random = new Random();
  }

  public boolean insert(int val) {

    if (!set.contains(val)) {
      set.add(val);
      return true;
    }

    return false;
  }

  public boolean remove(int val) {
    if (set.contains(val)) {
      set.remove(val);
      return true;
    }
    return false;
  }

  public int getRandom() {
    int size = set.size() - 1;
    int index = random.nextInt(size + 1);
    return (int) set.toArray()[index];
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
