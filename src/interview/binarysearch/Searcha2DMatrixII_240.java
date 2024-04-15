package interview.binarysearch;

import org.junit.Test;

public class Searcha2DMatrixII_240 {


  public boolean searchMatrix(int[][] matrix, int target) {

    int m = matrix.length;
    int n = matrix[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = i; j < n; j++) {
        if (matrix[i][j] <= target && matrix[i][n - 1] >= target) {
          boolean rowFound = binaryRowHelper(target, matrix, i, j, n - 1);
          if (rowFound) {
            return true;
          }
        }
        if (i + 1 < m && matrix[i + 1][j] <= target && matrix[m - 1][j] >= target) {
          boolean colFound = binaryColHelper(target, matrix, j, i + 1, m - 1);
          if (colFound) {
            return true;
          }
        }
        break;
      }
    }

    return false;
  }

  private boolean binaryColHelper(int target, int[][] matrix, int currentCol, int l, int h) {
    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (matrix[mid][currentCol] == target) {
        return true;
      } else if (matrix[mid][currentCol] > target) {
        h = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return false;
  }

  private boolean binaryRowHelper(int target, int[][] matrix, int currentRow, int l, int h) {

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


  @Test
  public void test() {
    int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}};
    System.out.println(searchMatrix(matrix, 5));
  }

  @Test
  public void test2() {
    int[][] matrix = {{1, 1}};
    System.out.println(searchMatrix(matrix, -2));
  }
}
