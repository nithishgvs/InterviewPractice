package interview.arrays;

import org.junit.Test;

public class ToeplitzMatrix_766 {


  public boolean isToeplitzMatrix(int[][] matrix) {

    for (int i = 0; i < matrix.length - 1; i++) {
      for (int j = 0; j < matrix[0].length - 1; j++) {
        if (matrix[i][j] != matrix[i + 1][j + 1]) {
          return false;
        }
      }
    }
    return true;

  }


  @Test
  public void test() {
    System.out.println(isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
  }


}
