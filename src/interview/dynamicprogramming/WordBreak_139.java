package interview.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {

  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] wordBreakTracker = new boolean[s.length() + 1];

    //Base case
    wordBreakTracker[0] = true;

    //To avoid duplicates
    Set<String> setTracker = new HashSet<>(wordDict);

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (wordBreakTracker[j] && setTracker.contains(s.substring(j, i))) {
          wordBreakTracker[i] = true;
          break;
        }
      }
    }

    // The last entry in wordBreakTracker tells if the entire string can be segmented or not
    return wordBreakTracker[s.length()];
  }

}
