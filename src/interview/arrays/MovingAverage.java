package interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class MovingAverage {


  int size;
  int sum;
  int index;
  Map<Integer, Integer> prefixSum = new HashMap<>();

  public MovingAverage(int size) {
    this.size = size;
    this.sum = 0;
    this.index = 0;
  }

  public double next(int val) {
    sum += val;
    prefixSum.put(index, sum);
    index++;
    int prevIndex = index - size - 1;
    if (!prefixSum.containsKey(prevIndex)) {
      return (double) sum / prefixSum.size();
    } else {
      int newValue = sum - prefixSum.get(prevIndex);
      return (double) newValue / size;
    }
  }


  public static void main(String[] args) {
    MovingAverage movingAverage = new MovingAverage(3);
    System.out.println(movingAverage.next(1));
    System.out.println(movingAverage.next(10));
    System.out.println(movingAverage.next(3));
    System.out.println(movingAverage.next(5));
  }

}
