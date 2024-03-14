package interview.arrays;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {

  Set<Integer> set = new HashSet<>();

  public boolean isHappy(int n) {
    if (n == 1) {
      return true;
    }

    int result = 0;

    while (n != 0) {
      int modulo = n % 10;
      result += Math.pow(modulo, 2);
      n = n / 10;
    }

    if (set.contains(result)) {
      return false;
    }

    set.add(result);

    return isHappy(result);
  }
}
