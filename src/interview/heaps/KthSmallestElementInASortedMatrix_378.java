package interview.heaps;

import java.util.PriorityQueue;
import org.junit.Test;

public class KthSmallestElementInASortedMatrix_378 {

  public int kthSmallest(int[][] matrix, int k) {

    int totalElements = matrix[0].length * matrix.length - k + 1;

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        minHeap.add(matrix[i][j]);
        while (minHeap.size() > totalElements) {
          minHeap.poll();
        }
      }
    }

    return minHeap.peek();

  }

  @Test
  public void test() {
    int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
    kthSmallest(matrix, 8);
  }

  @Test
  public void test2() {
    int[][] matrix = {{1, 2}, {1, 3}};
    kthSmallest(matrix, 3);
  }
}
