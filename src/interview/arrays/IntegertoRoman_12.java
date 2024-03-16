package interview.arrays;

import org.junit.Test;

public class IntegertoRoman_12 {
  public String intToRoman(int num) {
    StringBuilder stringBuilder = new StringBuilder();
    Integer[] numbers = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    int index = numbers.length - 1;

    while (num > 0) {
      while (num >= numbers[index]) {
        num = num - numbers[index];
        stringBuilder.append(romans[index]);
      }
      index--;

    }
    return stringBuilder.toString();
  }


  @Test
  public void test() {
    System.out.println(intToRoman(1994));
  }

}
