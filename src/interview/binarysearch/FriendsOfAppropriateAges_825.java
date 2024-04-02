package interview.binarysearch;

import java.util.Arrays;
import org.junit.Test;

public class FriendsOfAppropriateAges_825 {


  public int numFriendRequests(int[] ages) {

    Arrays.sort(ages);

    int[] dp = new int[ages.length];

    for (int i = 1; i < ages.length; i++) {
      int currAge = ages[i];
      int index = canSendIndex(ages, 0, i - 1, currAge);
      if (index != -1) {
        int friendsCount = i - index;
        dp[i] = friendsCount;
        int newIndex = i - 1;
        while (newIndex >= index && ages[newIndex] == currAge) {
          dp[newIndex] = dp[i];
          newIndex--;
        }
      }
    }

    return Arrays.stream(dp).sum();

  }


  private int canSendIndex(int[] ages, int l, int h, int currAge) {
    int index = -1;
    while (l <= h) {
      int mid = l + (h - l) / 2;
      int midAge = ages[mid];
      Double function = 0.5 * currAge + 7;
      if (!(currAge < 100 && midAge > 100)) {
        if (midAge > function) {
          index = mid;
          h = mid - 1;
        } else {
          l = mid + 1;
        }
      }
    }
    return index;
  }

  @Test
  public void test() {
    int[] ages = {16,17,18};
    System.out.println(numFriendRequests(ages));
  }

  @Test
  public void test1() {
    int[] ages = {8, 85, 24, 85, 69};
    System.out.println(numFriendRequests(ages));
  }

  @Test
  public void test12() {
    int[] ages = {16, 16, 16};
    System.out.println(numFriendRequests(ages));
  }


}
