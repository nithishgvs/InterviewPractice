package interview.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class CheckifOneStringSwapCanMakeStringsEqual_1790 {


  public boolean areAlmostEqual(String s1, String s2) {

    if (s1.length() != s2.length()) {
      return false;
    }

    if (s1.equals(s2)) {
      return true;
    }

    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        list.add(i);
      }
      if (list.size() > 2) {
        return false;
      }
    }

    return list.size() == 2 && s1.charAt(list.get(0)) == s2.charAt(list.get(1))
        && s2.charAt(list.get(0)) == s1.charAt(list.get(1));
  }


  @Test
  public void test() {
    //System.out.println(areAlmostEqual("aa", "ac"));
    System.out.println(areAlmostEqual("caa", "aaz"));
  }


}
