package interview.graph;

import org.junit.Test;

public class WordSearch {


  public boolean exist(char[][] board, String word) {

    int m = board.length;
    int n = board[0].length;

    boolean[][] visited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        final boolean found = dfs(board, visited, m, n, i, j, 0, word);
        if (found) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean dfs(char[][] board, boolean[][] visited, int m, int n, int currRow, int currCol,
      int index, String word) {

    if (currRow < 0 || currCol < 0 || currRow >= m || currCol >= n || visited[currRow][currCol]) {
      return false;
    }

    if (board[currRow][currCol] != word.charAt(index)) {
      return false;
    }
    if (index == word.length() - 1) {
      return true;
    }

    visited[currRow][currCol] = true;
    index += 1;
    boolean left = dfs(board, visited, m, n, currRow - 1, currCol, index, word);
    boolean right = dfs(board, visited, m, n, currRow + 1, currCol, index, word);
    boolean up = dfs(board, visited, m, n, currRow, currCol - 1, index, word);
    boolean down = dfs(board, visited, m, n, currRow, currCol + 1, index, word);
    visited[currRow][currCol] = false;

    return left || right || up || down;
  }

  @Test
  public void test() {
    char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    System.out.println(exist(board, "ABCCED"));
  }

}
