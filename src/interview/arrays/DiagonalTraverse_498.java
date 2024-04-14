package interview.arrays;

import org.junit.Test;

public class DiagonalTraverse_498 {



  public int[] findDiagonalOrder(int[][] mat) {

    //https://www.youtube.com/watch?v=NTF7sDU0IWA
    if (mat.length == 0 || mat[0].length == 0) {
      return new int[0];
    }

    int m = mat.length;
    int n = mat[0].length;

    //Result matrix
    int[] result = new int[m * n];

    int row = 0;
    int col = 0;

    boolean up = true;

    int index = 0;

    while (row < m && col < n) {

      //If diagonol is going up

      if (up) {
        while (row > 0 && col < n - 1) {
          result[index++] = mat[row][col];
          row--;
          col++;
        }
        //After this loop we miss one entry last column n-1
        result[index++] = mat[row][col];
        if (col == n - 1) {
          row++;
        } else {
          col++;
        }
      } //If diagonal is going down
      else {
        while (col > 0 && row < m - 1) {
          result[index++] = mat[row][col];
          row++;
          col--;
        }
        //After this loop we miss one entry last row n-1
        result[index++] = mat[row][col];

        if (row == m - 1) {
          col++;
        } else {
          row++;
        }
      }
      up = !up;
    }

    return result;
  }

  @Test
  public void test() {
    int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    findDiagonalOrder(mat);
  }
}
