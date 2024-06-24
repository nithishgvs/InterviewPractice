package interview.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class StickerstoSpellWord_691 {

  public int minStickers(String[] stickers, String target) {
    // Step 1: Create a frequency map for each sticker
    Map<String, Map<Character, Integer>> map = new HashMap<>();
    for (String str : stickers) {
      Map<Character, Integer> subMap = new HashMap<>();
      for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        subMap.put(ch, subMap.getOrDefault(ch, 0) + 1);
      }
      map.put(str, subMap);
    }

    // Step 2: Use DFS with memoization to find the minimum number of stickers
    int res = dfs(target, new HashMap<>(), map);
    // If res is less than 1 or greater than Integer.MAX_VALUE, return -1
    return res < 1 || res >= Integer.MAX_VALUE ? -1 : res;
  }

  int dfs(String targetString, HashMap<String, Integer> dp, Map<String, Map<Character, Integer>> map) {
    // Base case: if targetString is empty, no stickers are needed
    if (targetString.length() == 0) {
      return 0;
    }

    // If we have already computed the result for this targetString, return it
    if (dp.containsKey(targetString)) {
      return dp.get(targetString);
    }

    int res = Integer.MAX_VALUE;

    // Try each sticker to see if it helps reduce the targetString
    for (String str : map.keySet()) {
      Map<Character, Integer> currentMap = new HashMap<>(map.get(str));
      String temp = targetString;
      char ch = temp.charAt(0);

      // If the current sticker contains the first character of the targetString
      if (currentMap.containsKey(ch)) {
        // Try to remove as many matching characters from the targetString as possible
        for (int i = 0; i < temp.length(); i++) {
          ch = temp.charAt(i);
          if (currentMap.containsKey(ch) && currentMap.get(ch) > 0) {
            currentMap.put(ch, currentMap.get(ch) - 1);
            temp = temp.substring(0, i) + temp.substring(i + 1);
            i--;
          }
        }

        // If the sticker helped reduce the length of targetString, compute the result recursively
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
