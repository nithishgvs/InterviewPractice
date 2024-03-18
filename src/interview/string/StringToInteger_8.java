package interview.string;

import org.junit.Test;

public class StringToInteger_8 {


  public int myAtoi(String s) {

    double result = 0;
    s = s.trim();

    if (s.length() == 0) {
      return 0;
    }

    boolean isNegative = false;

    int startIndex = 0;
    if (s.charAt(0) == '-' || s.charAt(0) == '+') {
      isNegative = s.charAt(0) == '-' ? true : false;
      ++startIndex;
    }

    for (int i = startIndex; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (!Character.isDigit(ch)) {
        break;
      }
      result = (ch - '0') + (10 * result);

    }

    if (isNegative) {
      result *= -1;
    }

    if (result > Integer.MAX_VALUE) {
      result = Integer.MAX_VALUE;
    } else if (result < Integer.MIN_VALUE) {
      result = Integer.MIN_VALUE;
    }

    return (int) result;
  }


  @Test
  public void test() {
    System.out.println(myAtoi("9223372036854775808"));
  }

}
