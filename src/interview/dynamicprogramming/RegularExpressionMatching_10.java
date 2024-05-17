package interview.dynamicprogramming;

import org.junit.Test;

public class RegularExpressionMatching_10 {

  public boolean isMatch(String s, String p) {
    //https://www.youtube.com/watch?v=HAA8mgxlov8
    boolean[][] cache = new boolean[s.length() + 1][p.length() + 1];
    return dfs(cache, s, p, 0, 0);
  }

  boolean dfs(boolean[][] cache, String s, String p, int i, int j) {
    if (cache[i][j] != false) {
      return cache[i][j];
    }
    if (i >= s.length() && j >= p.length()) {
      return true;
    }
    if (j >= p.length()) {
      return false;
    }
    boolean match =
        i < s.length() &&
            (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
      //Dont use * dfs(i,j+2,s,p)
      //Use * if there is a match with current char
      cache[i][j] =
          dfs(cache, s, p, i, j + 2) ||
              (match && dfs(cache, s, p, i + 1, j));
    } else {
      cache[i][j] = match && dfs(cache, s, p, i + 1, j + 1);
    }

    return cache[i][j];
  }

  @Test
  public void test() {
    System.out.println(isMatch("ab", ".*c"));
  }
}
