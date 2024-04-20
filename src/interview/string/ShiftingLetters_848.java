package interview.string;

import org.junit.Test;

public class ShiftingLetters_848 {


  public String shiftingLetters(String s, int[] shifts) {

    char[] arr = s.toCharArray();

    int count = 0;

    for (int i = shifts.length - 1; i > -1; i--) {
      count = (count + shifts[i]) % 26;
      if (count > 26) {
        count = count % 26;
      }
      int ascii = count + arr[i];
      while (ascii > 122) {
        ascii = ascii - 26;
      }
      arr[i] = (char) (ascii);
    }

    return String.valueOf(arr);
  }


  @Test
  public void test() {
    int[] shifts = {74, 34, 65, 30, 43, 91, 14, 10};
    System.out.println(shiftingLetters("gdhbjaph", shifts));
  }

}
