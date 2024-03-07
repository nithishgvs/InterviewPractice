package interview.bitmanipulation;

public class SingleNumber_136 {

  public int singleNumber(int[] nums) {
    int number = 0;
    for (int num : nums) {
      number = number ^ num;
    }
    return number;
  }
}
