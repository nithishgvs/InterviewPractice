package interview.arrays;

import org.junit.Test;

public class FactorialTrailingZeroes_172 {


  public int trailingZeroes(int n) {
    int zeroCount = 0;
    while (n > 0) {
      n /= 5;
      zeroCount += n;
    }
    return zeroCount;
  }

  @Test
  public void test(){
    System.out.println(trailingZeroes(100));
  }


}
