package interview.binarysearch;

import java.util.List;

public class LeftmostColumnwithatLeastaOne_1428 {


  interface BinaryMatrix {

    public int get(int row, int col);

    public List<Integer> dimensions();
  }

  BinaryMatrix binaryMatrix;

  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

    this.binaryMatrix = binaryMatrix;
    List<Integer> dimensions = binaryMatrix.dimensions();
    int m = dimensions.get(0);
    int n = dimensions.get(1);

    int low = 0, high = n - 1;
    int ans = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (isOneFound(mid, m)) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }

  public boolean isOneFound(int col, int m) {

    for (int row = 0; row < m; row++) {
      if (binaryMatrix.get(row, col) == 1) {
        return true;
      }
    }

    return false;
  }
}
