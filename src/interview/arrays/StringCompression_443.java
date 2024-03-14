package interview.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringCompression_443 {

  public int compress(char[] chars) {
    Map<Character, Integer> map = new LinkedHashMap<>();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      Integer value = map.getOrDefault(chars[i], 0);
      map.put(chars[i], value + 1);

      if (i > 0 && chars[i - 1] != chars[i]) {
        stringBuilder.append(chars[i - 1]);
        helper(chars, map, i, stringBuilder);
        map.remove(chars[i - 1]);
      }

      if (i == chars.length - 1) {
        stringBuilder.append(chars[i]);
        helper(chars, map, i + 1, stringBuilder);
      }
    }

    for (int i = 0; i < stringBuilder.length(); i++) {
      chars[i] = stringBuilder.charAt(i);
    }
    return stringBuilder.length();
  }

  private static void helper(char[] chars, Map<Character, Integer> map, int i,
      StringBuilder stringBuilder) {
    Integer num = map.get(chars[i - 1]);
    if (num > 1) {
      StringBuilder temp = new StringBuilder();
      while (num > 0) {
        int modulo = num % 10;
        temp.append(modulo);
        num = num / 10;
      }
      stringBuilder.append(temp.reverse());
    }
  }
}
