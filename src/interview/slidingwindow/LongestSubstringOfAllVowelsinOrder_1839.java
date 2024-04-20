package interview.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringOfAllVowelsinOrder_1839 {

  public int longestBeautifulSubstring(String word) {
    int maxLength = 0;

    Map<Character, Integer> indexMap = Map.of('a', 1, 'e', 2, 'i', 3, 'o', 4, 'u', 5, '\0', -1);

    char previousChar = '\0';

    int start = 0;
    int startIndex = 0;

    Map<Character, Integer> map = new HashMap<>();

    while (start < word.length()) {

      char currChar = word.charAt(start);
      if (!map.containsKey(currChar)) {
        map.put(currChar, start);
      }
      if (indexMap.get(currChar) >= indexMap.get(previousChar)) {
        if (hasAllChars(map)) {
          maxLength = Math.max(maxLength, start - startIndex + 1);
        }
      } else {
        startIndex = start;
        map.clear();
        map.put(currChar, start);
      }
      previousChar = currChar;

      start++;

    }

    return maxLength;
  }

  private boolean hasAllChars(Map<Character, Integer> map) {
    return map.keySet().size() == 5;
  }
}
