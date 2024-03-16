package interview.arrays;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class RomanToInteger_12 {


  /**
   * Integer[] numbers = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000}; String[] romans =
   * {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
   *
   * @param s
   * @return
   */
  public int romanToInt(String s) {
    int number = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      switch (ch) {
        case 'I':
          if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
            number += 4;
            i++;
          } else if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
            number += 9;
            i++;
          } else {
            number += 1;
          }
          break;
        case 'V':
          number += 5;
          break;
        case 'X':
          if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
            number += 40;
            i++;
          } else if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
            number += 90;
            i++;
          } else {
            number += 10;
          }
          break;
        case 'L':
          number += 50;
          break;
        case 'C':
          if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
            number += 400;
            i++;
          } else if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
            number += 900;
            i++;
          } else {
            number += 100;
          }
          break;
        case 'D':
          number += 500;
          break;
        case 'M':
          number += 1000;
          break;

      }
    }
    return number;

  }

  @Test
  public void test() {
    System.out.println(romanToInt("LVIII"));
  }

}
