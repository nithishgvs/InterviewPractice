package interview.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString_438 {

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();

    if (s.length() < p.length())
      return result;

    Map<Character, Integer> targetMap = new HashMap<>();
    Map<Character, Integer> sourceMap = new HashMap<>();


    for (int i = 0; i < p.length(); i++) {
      sourceMap.put(s.charAt(i), sourceMap.getOrDefault(s.charAt(i), 0) + 1);
      targetMap.put(p.charAt(i), targetMap.getOrDefault(p.charAt(i), 0) + 1);
    }


    int left = 0;

    int right = p.length();

    if (sourceMap.equals(targetMap)) {
      result.add(0);
    }


    while (right < s.length()) {
      char charCurrent = s.charAt(right);

      sourceMap.put(charCurrent, sourceMap.getOrDefault(charCurrent, 0) + 1);

      char discardChar = s.charAt(left);

      sourceMap.put(discardChar, sourceMap.getOrDefault(discardChar, 0) - 1);

      if (sourceMap.get(discardChar) == 0) {
        sourceMap.remove(discardChar);
      }

      left++;
      right++;

      if (sourceMap.equals(targetMap)) {
        result.add(left);
      }

    }


    return result;
  }

}
