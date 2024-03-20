package interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class StringCompression_443 {

  public int compress(char[] chars) {
    Map<Character, Integer> map = new HashMap<>();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
      if ((i > 0 && chars[i - 1] != chars[i])) {
        final char ch = chars[i - 1];
        final int number = map.get(ch);
        stringBuilder.append(ch);
        stringBuilder.append(numberConversion(number));
        map.remove(ch);
      }
      if (i == chars.length - 1) {
        stringBuilder.append(chars[i]);
        if (map.get(chars[i]) > 1) {
          stringBuilder.append(map.get(chars[i]));
        }
      }
    }

    for (int i = 0; i < stringBuilder.length(); i++) {
      chars[i] = stringBuilder.charAt(i);
    }

    return stringBuilder.toString().length();
  }


  private String numberConversion(int num) {
    StringBuilder temp = new StringBuilder();
    if (num > 1) {
      while (num != 0) {
        temp.append(num % 10);
        num = num / 10;
      }
    }
    return temp.reverse().toString();
  }
}
