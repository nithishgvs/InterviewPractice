package interview.binarysearch;

import org.junit.Test;

public class CountNegativeNumbersinaSortedMatrix_1351 {


  public int countNegatives(int[][] grid) {

    int count = 0;

    for (int i = 0; i < grid.length; i++) {

      int index = binarySearchHelper(grid, i);
      if (index != -1) {
        count += grid[0].length - index;
      }
    }

    return count;

  }

  private int binarySearchHelper(int[][] grid, int row) {

    int l = 0;
    int h = grid[0].length - 1;

    while (l < h) {
      int mid = l + (h - l) / 2;
      if (grid[row][mid] < 0) {
        h = mid;
      } else {
        l = mid + 1;
      }
    }

    return (grid[row][l] < 0) ? l : -1;
  }


  @Test
  public void test() {
    int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
    System.out.println(countNegatives(grid));
  }


  @Test
  public void test2() {
    int[][] grid = {{1, -1}, {-1, -1}};
    System.out.println(countNegatives(grid));
  }


  @Test
  public void test3() {
    int[][] grid = {{3, 2}, {1, 0}};
    System.out.println(countNegatives(grid));
  }
}
