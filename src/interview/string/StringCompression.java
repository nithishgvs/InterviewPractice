package interview.string;

import org.junit.Test;

public class StringCompression {

  public int compress(char[] chars) {

    StringBuilder resultBuilder = new StringBuilder();

    int count = 1;

    for (int i = 1; i < chars.length; i++) {
      if (chars[i] != chars[i - 1]) {
        updateStringBuilder(chars[i - 1], count, resultBuilder);
        count = 1;
      } else {
        count++;
      }
    }

    updateStringBuilder(chars[chars.length - 1], count, resultBuilder);

    for (int i = 0; i < resultBuilder.length(); i++) {
      chars[i] = resultBuilder.charAt(i);
    }

    return resultBuilder.length();
  }

  private void updateStringBuilder(char currentChar, int count, StringBuilder resultBuilder) {
    resultBuilder.append(currentChar);
    if (count > 1) {
      StringBuilder temp = new StringBuilder();
      while (count != 0) {
        temp.append(count % 10);
        count = count / 10;
      }
      resultBuilder.append(temp.reverse());
    }
  }

  @Test
  public void test() {
    char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
    System.out.println(compress(chars));
  }

  @Test
  public void test2() {
    char[] chars = {'a'};
    System.out.println(compress(chars));
  }

}
