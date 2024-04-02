package interview.arrays;

import org.junit.Test;

public class PermutationinString_567 {


  public boolean checkInclusion(String s1, String s2) {

    int[] s1Arr = generateCounter(s1);

    for (int i = 0; i < s2.length(); i++) {

      char ch = s2.charAt(i);

      if (s1Arr[ch - 'a'] > 0) {
        //Character found
        int lastIndex = s1.length();
        if (i + lastIndex - 1 < s2.length()) {
          String sub = s2.substring(i, i + lastIndex);
          if (checkMatch(s1Arr.clone(), sub)) {
            return true;
          }
        }
      }

    }

    return false;
  }

  private boolean checkMatch(int[] s1Arr, String s2String) {
    for (int i = 0; i < s2String.length(); i++) {
      if (s1Arr[s2String.charAt(i) - 'a'] <= 0) {
        return false;
      }
      s1Arr[s2String.charAt(i) - 'a']--;
    }

    return true;
  }


  public int[] generateCounter(String s1) {
    int[] s1Arr = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      s1Arr[s1.charAt(i) - 'a']++;
    }
    return s1Arr;
  }


  @Test
  public void test() {
    checkInclusion("adc", "dcda");
  }
}
