package interview.arrays;

import java.util.Arrays;

public class PlusOne_66 {

  public int[] plusOne(int[] digits) {
    boolean carry = false;
    boolean added = false;

    for (int i = digits.length - 1; i > -1; i--) {
      int currentDigit = digits[i];
      if (!added) {
        currentDigit = currentDigit + 1;
        added = true;
      }
      if (carry) {
        currentDigit++;
        carry = false;
      }
      if (currentDigit == 10) {
        carry = true;
        digits[i] = 0;
      } else {
        digits[i] = currentDigit;
      }
    }

    if (carry) {
      int[] newArray = Arrays.copyOf(digits, digits.length + 1);
      newArray[0] = 1;
      return newArray;
    }

    return digits;
  }
}
