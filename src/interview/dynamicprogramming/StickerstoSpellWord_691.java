package interview.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class StickerstoSpellWord_691 {

  public int minStickers(String[] stickers, String target) {
    Map<String, Map<Character, Integer>> map = new HashMap<>();
    for (String str : stickers) {
      Map<Character, Integer> subMap = new HashMap<>();
      for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        subMap.put(ch, subMap.getOrDefault(ch, 0) + 1);
      }
      map.put(str, subMap);
    }
    int res = dfs(target, new HashMap<>(), map);
    return res < 1 || res >= Integer.MAX_VALUE ? -1 : res;
  }


  int dfs(String targetString, HashMap<String, Integer> dp, Map<String, Map<Character, Integer>> map) {
    if (targetString.length() == 0) {
      return 0;
    }

    if (dp.containsKey(targetString)) {
      return dp.get(targetString);
    }

    int res = Integer.MAX_VALUE;

    for (String str : map.keySet()) {
      Map<Character, Integer> currentMap = new HashMap(map.get(str));
      String temp = targetString;

      char ch = temp.charAt(0);
      if (currentMap.containsKey(ch)) {
        for (int i = 0; i < temp.length(); i++) {
          ch = temp.charAt(i);
          if (currentMap.containsKey(ch) && currentMap.get(ch) > 0) {
            currentMap.put(ch, currentMap.get(ch) - 1);
            temp = temp.substring(0, i) + temp.substring(i + 1);
            i--;
          }
        }
        if (temp.length() != targetString.length()) {
          res = Math.min(res, 1 + dfs(temp, dp, map));
          dp.put(targetString, res);
        }
      }
    }
    return res;
  }

  @Test
  public void test() {
    String[] stickers = {"with", "example", "science"};
    System.out.println(minStickers(stickers, "thehat"));
  }

  @Test
  public void test2() {
    String[] stickers = {"notice", "possible"};
    System.out.println(minStickers(stickers, "basicbasic"));
  }

}
