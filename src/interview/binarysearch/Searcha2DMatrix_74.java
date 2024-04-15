package interview.binarysearch;

public class Searcha2DMatrix_74 {


  public boolean searchMatrix(int[][] matrix, int target) {

    int cols = matrix[0].length;

    for (int i = 0; i < matrix.length; i++) {

      if (matrix[i][0] <= target && matrix[i][cols - 1] >= target) {
        boolean found = binarySearchHelper(matrix, i, 0, cols - 1, target);
        if (found) {
          return true;
        }
      }

    }

    return false;

  }

  private boolean binarySearchHelper(int[][] matrix, int currentRow, int l, int h, int target) {

    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (matrix[currentRow][mid] == target) {
        return true;
      } else if (matrix[currentRow][mid] > target) {
        h = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return false;
  }
}
