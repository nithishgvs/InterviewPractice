package interview.dynamicprogramming;

import org.junit.Test;

public class RegularExpressionMatching {

  public boolean isMatch(String s, String p) {

    boolean[][] cache = new boolean[s.length() + 1][p.length() + 1];

    return dfs(0, 0, cache, s, p);

  }

  private boolean dfs(int i, int j, boolean[][] cache, String s, String p) {

    if (!cache[i][j]) {
      return cache[i][j];
    }

    if (i >= s.length() && j >= s.length()) {
      return true;
    }

    //Still has some pattern to match
    if (j >= p.length()) {
      return false;
    }

    boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
      cache[i][j] = dfs(i, j + 2, cache, s, p) || (match && dfs(i + 1, j, cache, s, p));
    }

    if (match) {
      cache[i][j] = dfs(i + 1, j + 1, cache, s, p);
    }

    return cache[i][j];
  }


  @Test
  public void test() {
    System.out.println(isMatch("ab", "*"));
  }
}
