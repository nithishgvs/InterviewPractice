package interview.string;

public class AddStrings_415 {

  public String addStrings(String num1, String num2) {
    int carry = 0;

    StringBuilder stringBuilder = new StringBuilder();

    int i = num1.length() - 1, j = num2.length() - 1;

    while (i > -1 || j > -1) {
      int number1 = 0;
      int number2 = 0;
      if (i > -1) {
        number1 = num1.charAt(i) - '0';
        i--;
      }

      if (j > -1) {
        number2 = num2.charAt(j) - '0';
        j--;
      }

      int total = number1 + number2 + carry;
      stringBuilder.append(total % 10);
      carry = total / 10;
    }

    if (carry != 0) {
      stringBuilder.append(carry);
    }

    return stringBuilder.reverse().toString();
  }
}
