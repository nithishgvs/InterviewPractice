package interview.arrays;

public class MisplacedIndex {

  public static int[] fixArray(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        swap(i, i + 1, arr);
      }
    }

    for (int i = arr.length - 1; i >= 1; i--) {
      if (arr[i] < arr[i - 1]) {
        swap(i - 1, i, arr);
      }
    }
    return arr;
  }

  public static void swap(int i, int j, int[] arr) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 4, 5};
    fixArray(nums);
  }

}
