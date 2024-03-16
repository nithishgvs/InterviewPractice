package interview.arrays;

import org.junit.Test;

public class RotateImage_48 {

  public void rotate(int[][] matrix) {

    //Transpose of a matrix
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix[0].length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    //Swap elements in reverse order
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][matrix.length - j - 1];
        matrix[i][matrix.length - j - 1] = temp;
      }
    }

  }


  @Test
  public void test() {
    rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
  }
}
