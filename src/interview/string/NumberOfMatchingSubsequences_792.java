package interview.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class NumberOfMatchingSubsequences_792 {

  public int numMatchingSubseq(String s, String[] words) {
    int result = 0;

    Map<String, Integer> map = new HashMap<>();

    Arrays.stream(words).forEach(word -> {
      if (!map.containsKey(word)) {
        map.put(word, 0);
      }
      map.put(word, map.get(word) + 1);
    });

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (isSubsequence(entry.getKey(), s)) {
        result += entry.getValue();
      }
    }

    return result;

  }

  private boolean isSubsequence(String s, String t) {
    if (s.length() == 0 || (s.length() == 0 && t.length() == 0)) {
      return true;
    }

    int sPtr = 0, tPtr = 0;

    while (tPtr < t.length()) {
      if (s.charAt(sPtr) == t.charAt(tPtr)) {
        sPtr++;
      }
      if (sPtr == s.length()) {
        return true;
      }
      tPtr++;
    }
    return false;
  }

  @Test
  public void test() {
    String[] words = {"a", "bb", "acd", "ace"};
    System.out.println(numMatchingSubseq("abcde", words));

  }

}
