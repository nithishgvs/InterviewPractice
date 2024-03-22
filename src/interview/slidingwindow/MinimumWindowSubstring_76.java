package interview.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class MinimumWindowSubstring_76 {


  public String minWindow(String s, String t) {

    Map<Character, Integer> tMap = generateFreqMap(t);

    String result = "";

    Map<Character, Integer> currentMap = new HashMap<>();

    int start = 0;

    int startIndex = 0;

    while (start < s.length()) {
      currentMap.put(s.charAt(start), currentMap.getOrDefault(s.charAt(start), 0) + 1);

      while (mapCountsMatch(tMap, currentMap)) {
        String temp = s.substring(startIndex, start + 1);
        if (result.isEmpty()) {
          result = temp;
        } else if (temp.length() <= result.length()) {
          result = temp;
        }
        Integer value = currentMap.get(s.charAt(startIndex));
        if (value == 1) {
          currentMap.remove(s.charAt(startIndex));
        } else {
          currentMap.put(s.charAt(startIndex), value - 1);
        }
        startIndex++;
      }
      start++;
    }

    return result;
  }

  private boolean mapCountsMatch(Map<Character, Integer> tMap, Map<Character, Integer> currentMap) {
    if (!currentMap.keySet().containsAll(tMap.keySet())) {
      return false;
    }
    for (Character character : tMap.keySet()) {
      if (currentMap.get(character) < tMap.get(character)) {
        return false;
      }
    }
    return true;
  }

  private Map<Character, Integer> generateFreqMap(String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    return map;
  }


  @Test
  public void test() {
    //minWindow("ADOBECODEBANC", "ABC");
    minWindow("a", "aa");
  }

}
