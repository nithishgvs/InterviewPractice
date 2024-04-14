package interview.arrays;

import org.junit.Test;

public class ValidNumber_65 {


  public boolean isNumber(String s) {

    boolean seenDigit = false;
    boolean seenExponent = false;
    boolean seenDot = false;

    for (int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);
      if (Character.isDigit(curr)) {
        seenDigit = true;
      } else if (curr == '+' || curr == '-') {
        if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
          return false;
        }
      } else if (curr == 'e' || curr == 'E') {
        if (seenExponent || !seenDigit) {
          return false;
        }
        seenExponent = true;
        seenDigit = false;
      } else if (curr == '.') {
        if (seenDot || seenExponent) {
          return false;
        }
        seenDot = true;
      } else {
        return false;
      }
    }

    return seenDigit;
  }

  @Test
  public void test() {
    String[] valids = new String[]{"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3",
        "3e+7", "+6e-1", "53.5e93", "-123.456e789"};

    for (String v : valids) {
      System.out.println(v + " :: " + isNumber(v));
    }

    String[] invalids = new String[]{"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};

    for (String v : invalids) {
      System.out.println(v + " :: " + isNumber(v));
    }
  }

}
