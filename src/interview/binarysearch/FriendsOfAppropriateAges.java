package interview.binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class FriendsOfAppropriateAges {

  public int numFriendRequests(int[] ages) {

    Arrays.sort(ages);

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 1; i < ages.length; i++) {
      int index = binarySearch(ages, 0, i - 1, ages[i]);
      if (index != -1) {
        map.put(ages[i], i - index);
      }
    }

    int max = 0;
    for (int i = 0; i < ages.length; i++) {
      max += map.getOrDefault(ages[i], 0);
    }

    return max;

  }

  private int binarySearch(int[] ages, int l, int h, int age) {

    int low = l;
    int high = h;

    int ans = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      double val = 0.5 * age + 7;
      if (ages[mid] > val) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return ans;

  }

  @Test
  public void test() {
    int[] ages = {20, 30, 100, 110, 120};
    System.out.println(numFriendRequests(ages));
  }

}
