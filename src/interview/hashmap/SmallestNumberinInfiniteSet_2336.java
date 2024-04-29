package interview.hashmap;

import java.util.TreeSet;

public class SmallestNumberinInfiniteSet_2336 {


  class SmallestInfiniteSet {

    TreeSet<Integer> treeSet;

    int counter = 1;

    public SmallestInfiniteSet() {
      treeSet = new TreeSet<>();
    }

    public int popSmallest() {
      treeSet.add(counter);
      counter++;
      return treeSet.pollFirst();
    }

    public void addBack(int num) {
      if (counter > num) {
        treeSet.add(num);
      }
    }
  }


  public static void main(String[] args) {
    SmallestNumberinInfiniteSet_2336 obj = new SmallestNumberinInfiniteSet_2336();
    SmallestInfiniteSet smallestInfiniteSet = obj.new SmallestInfiniteSet();

    smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
    smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
    smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
    smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
    smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
    smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
    // is the smallest number, and remove it from the set.
    smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
    smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
  }
}
