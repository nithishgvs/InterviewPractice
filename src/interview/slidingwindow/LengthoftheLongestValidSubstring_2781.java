package interview.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class LengthoftheLongestValidSubstring_2781 {


  public int longestValidSubstring(String word, List<String> forbidden) {
    //https://www.youtube.com/watch?v=oRCpeRtbogc
    Set<String> banned = new HashSet<>(forbidden);
    int longest = 0;

    int right = word.length() - 1;

    for (int left = word.length() - 1; left >= 0; left--) {
      for (int k = left; k <= Math.min(right, left + 9); k++) {
        if (banned.contains(word.substring(left, k + 1))) {
          right = k - 1;
          break;
        }
      }
      longest = Math.max(longest, right - left + 1);
    }
    return longest;
  }


  @Test
  public void test() {
    System.out.println(longestValidSubstring("leetcode", Arrays.asList("de","le","e")));
  }
}
