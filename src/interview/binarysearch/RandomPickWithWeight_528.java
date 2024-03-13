package interview.binarysearch;

import java.util.Random;

public class RandomPickWithWeight_528 {

  class Solution {

    int[] array;
    int sum;

    Random random = new Random();

    public Solution(int[] w) {
      array = new int[w.length];
      for (int i = 0; i < w.length; i++) {
        sum += w[i];
        array[i] = sum;
      }
    }

    public int pickIndex() {
      int randomPick = random.nextInt(sum) + 1;

      int l = 0, h = array.length - 1;

      while (l <= h) {
        int mid = l + (h - l) / 2;
        if (array[mid] == randomPick) {
          return mid;
        } else if (array[mid] > randomPick) {
          h = mid - 1;
        } else {
          l = mid + 1;
        }
      }

      return l;
    }

  }

}
