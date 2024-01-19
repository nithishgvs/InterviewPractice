package interview.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters_3 {

  public int lengthOfLongestSubstring(String s) {

    int maxLength = 0;

    int start = 0;
    int startIndex = 0;

    Map<Character, Integer> helperMap = new HashMap<>();

    while (start < s.length()) {

      char ch = s.charAt(start);

      helperMap.put(ch, helperMap.getOrDefault(ch, 0) + 1);

      while (!mapHasNonRepeatingChars(helperMap)) {
        helperMap.put(s.charAt(startIndex), helperMap.get(s.charAt(startIndex)) - 1);
        startIndex++;
      }
      maxLength = Math.max(maxLength, start - startIndex + 1);

      start++;

    }

    return maxLength;

  }

  private boolean mapHasNonRepeatingChars(Map<Character, Integer> helperMap) {
    return helperMap.keySet().stream().filter(key -> helperMap.get(key) > 1)
        .collect(Collectors.toSet()).isEmpty();
  }


  @Test
  public void test() {
    System.out.println(lengthOfLongestSubstring("bbbbb"));
  }

}
