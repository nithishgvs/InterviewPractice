package interview.graph;

import org.junit.Test;

public class WordSearch_79 {


  public boolean exist(char[][] board, String word) {

    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        boolean result = wordSearchHelper(i, j, board, word, 0, visited);
        if (result) {
          return result;
        }
      }
    }

    return false;

  }

  private boolean wordSearchHelper(int row, int col, char[][] board, String word, int index,
      boolean[][] visited) {
    //Edge case
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
        || board[row][col] != word.charAt(index) || visited[row][col]) {
      return false;
    }

    if (word.charAt(index) == board[row][col]) {
      if (index == word.length() - 1) {
        return true;
      }
      visited[row][col] = true;
      boolean l = wordSearchHelper(row, col - 1, board, word, index + 1, visited);
      boolean r = wordSearchHelper(row, col + 1, board, word, index + 1, visited);
      boolean u = wordSearchHelper(row - 1, col, board, word, index + 1, visited);
      boolean d = wordSearchHelper(row + 1, col, board, word, index + 1, visited);
      visited[row][col] = false;
      return l || r || u || d;
    }

    return false;
  }


  @Test
  public void test() {
    char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    System.out.println(exist(board, "ABCCED"));
  }
}
