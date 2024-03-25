package interview.arrays;

import org.junit.Test;

public class MultiplyStrings_43 {

  public String multiply(String num1, String num2) {

    int[] result = new int[num2.length() + num1.length()];

    for (int i = num1.length() - 1; i > -1; i--) {
      for (int j = num2.length() - 1; j > -1; j--) {
        int mul = Integer.valueOf(num1.charAt(i) - '0') * Integer.valueOf(num2.charAt(j) - '0');
        int p1 = i + j, p2 = i + j + 1;
        int sum = result[p2] + mul;
        int remainder = sum / 10;
        int modulo = sum % 10;
        result[p2] = modulo;
        if (remainder > 0) {
          result[p1] += remainder;
        }
      }
    }

    StringBuilder stringBuilder = new StringBuilder();

    for (int num : result) {
      if (stringBuilder.length() == 0 && num == 0) {
        continue;
      }
      stringBuilder.append(num);
    }

    return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();

  }


  @Test
  public void test() {
    //System.out.println(multiply("6913259244", "71103343"));
    System.out.println(multiply("9133", "0"));
    //System.out.println(multiply("123", "456"));
  }

}
