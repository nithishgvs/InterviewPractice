package interview.hashmap;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class IsomorphicStrings_205 {

  public boolean isIsomorphic(String s, String t) {
    return makePattern(s).equals(makePattern(t));
  }

  private String makePattern(String s) {
    Map<Character, Integer> map = new HashMap<>();
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if (!map.containsKey(s.charAt(i))) {
        map.put(s.charAt(i), i);
      }
      stringBuilder.append(map.get(s.charAt(i))).append("|");
    }
    return stringBuilder.toString();
  }

  @Test
  public void test() {
    System.out
        .println(isIsomorphic("abcdefghijklmnopqrstuvwxyzva", "abcdefghijklmnopqrstuvwxyzck"));
  }
}
