package interview.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {

    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    Set<String> words = new HashSet<>(wordDict);

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (words.contains(s.substring(j, i)) && dp[j]) {
          dp[i] = true;
          break;
        }


      }
    }

    return dp[dp.length - 1];

  }

  @Test
  public void test() {
    System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
  }

}
