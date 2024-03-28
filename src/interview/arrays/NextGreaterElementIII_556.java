package interview.arrays;

public class NextGreaterElementIII_556 {


  public int nextGreaterElement(int n) {

    //Similar to next permutation
    String numberString = String.valueOf(n);
    char[] charNums = numberString.toCharArray();

    //First we need to find the decreasing sequence of the nums from the last
    //After we encounter the index we swap with the least  element from the last
    //Then we reverse from index+1

    int i = charNums.length - 2;

    while (i >= 0 && charNums[i + 1] - '0' <= charNums[i] - '0') {
      i--;
    }

    //By now we will have where the increasing sequence ended
    //Now we swap the last least integer with index i (decreasing sequence ended here)
    //Here if array is in decreasing order 3,2,1 next would we 1,2,3 we dont need any swaps just reverse
    //After we swap we reverse the array after i so it will be in decreasing order

    if (i >= 0) {
      int j = charNums.length - 1;

      while (j >= 0 && charNums[j] - '0' <= charNums[i] - '0') {
        j--;
      }
      //swap i with j
      swapArray(charNums, i, j);
    }

    reverseArray(charNums, i + 1);

    Long number = Long.valueOf(String.valueOf(charNums));

    if (number < Integer.MIN_VALUE && number > Integer.MAX_VALUE) {
      return -1;
    }

    if (number.intValue() <= n) {
      return -1;
    }

    return number.intValue();
  }

  private void reverseArray(char[] charNums, int index) {
    int left = index;
    int right = charNums.length - 1;

    while (left < right) {
      swapArray(charNums, left, right);
      left++;
      right--;
    }
  }

  private void swapArray(char[] charNums, int i, int j) {
    char tmp = charNums[i];
    charNums[i] = charNums[j];
    charNums[j] = tmp;
  }

}
