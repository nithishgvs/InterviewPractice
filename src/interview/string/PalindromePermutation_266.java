package interview.string;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class PalindromePermutation_266 {

  public boolean canPermutePalindrome(String s) {

    Set<Character> set = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (set.contains(ch)) {
        set.remove(ch);
      } else {
        set.add(ch);
      }
    }

    return set.size() == 1;

  }

  @Test
  public void test(){
    String s="carerac";
    canPermutePalindrome(s);
  }


}
