package interview.bitmanipulation;

public class NumberOf1Bits_191 {

  public int hammingWeight(int n) {
    /**
     * If you do and of number with number-1 it with turn off last bit 1
     *
     * Ex: 100 (4) is number 011 is number -1 (3) if you and operation of both becomes 0 total is 1
     * EX: 101 n-1 is 100 first and makes it 100 and next and with 101 makes it 0 total is 2
     */
    int count = 0;

    while (n != 0) {
      n = n & (n - 1);
      count++;
    }

    return count;
  }
}
