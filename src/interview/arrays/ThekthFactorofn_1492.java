package interview.arrays;

public class ThekthFactorofn_1492 {


  public int kthFactor(int n, int k) {
    //We check until mid of the array and if we reach count we return if we dont reach return the n value
    int mid = (int) Math.ceil((double) n / 2.0);
    int count = 0;
    for (int i = 1; i <= mid; i++) {
      if ((n % i) == 0) {
        count++;
      }
      if (count == k) {
        return i;
      }
    }

    return count + 1 == k ? n : -1;
  }
}
