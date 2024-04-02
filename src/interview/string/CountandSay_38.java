package interview.string;

import org.junit.Test;

public class CountandSay_38 {


  public String countAndSay(int n) {

    if (n == 1) {
      return "1";
    }

    int current = 2;

    String num = "1";

    while (current <= n) {

      char numVal = num.charAt(0);
      int count = 1;
      StringBuilder stringBuilder = new StringBuilder();

      for (int i = 1; i < num.length(); i++) {
        if (num.charAt(i) == num.charAt(i - 1)) {
          count++;
        } else {
          stringBuilder.append(count).append(num.charAt(i - 1) - '0');
          count = 1;
          numVal = num.charAt(i);
        }
      }
      stringBuilder.append(count).append(numVal - '0');
      num = stringBuilder.toString();
      current++;
    }

    return num;
  }


  @Test
  public void test() {
    countAndSay(5);
  }


}
