package interview.arrays;

public class MovingAverage {


  int size;

  int[] array = new int[1000000];

  int index = -1;

  public MovingAverage(int size) {
    this.size = size;
  }

  public double next(int val) {
    if (index > -1) {
      int tempIndex = index + 1;
      array[tempIndex] += val + array[tempIndex - 1];
      index = tempIndex;
    } else {
      array[++index] = val;
    }

    if (index - size >= 0) {
      return (double) (array[index] - array[index - size]) / size;
    } else {
      return (double) array[index] / (index + 1);
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
