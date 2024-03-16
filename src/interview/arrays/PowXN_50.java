package interview.arrays;

import org.junit.Test;

public class PowXN_50 {


  public double myPow(double x, int n) {
    double result = helper(x, Math.abs(n));
    return n < 0 ? 1 / result : result;
  }

  private double helper(double x, int n) {

    if (n == 0) {
      return 1;
    }
    if (x == 0) {
      return 0;
    }

    double result = helper(x, n / 2);
    result = (n % 2 == 0) ? result * result : result * result * x;
    return result;
  }


  @Test
  public void test() {
    System.out.println(myPow(2.0000, -2));
  }
}
