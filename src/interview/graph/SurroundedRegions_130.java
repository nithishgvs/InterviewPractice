package interview.graph;

import org.junit.Test;

public class SurroundedRegions_130 {


  public void solve(char[][] board) {

    int m = board.length;
    int n = board[0].length;

    boolean[][] visited = new boolean[m][n];

    //Top row which is a border
    for (int i = 0; i < n; i++) {
      if (board[0][i] == 'O' && !visited[0][i]) {
        dfs(0, i, m, n, visited, board);
      }
    }

    //Bottom row which is a border
    for (int i = 0; i < n; i++) {
      System.out.println(m-1+"::"+i);
      if (board[m - 1][i] == 'O' && !visited[m - 1][i]) {
        dfs(m - 1, i, m, n, visited, board);
      }
    }

    //Left column which is a border
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'O' && !visited[i][0]) {
        dfs(i, 0, m, n, visited, board);
      }
    }

    //Right column which is a border
    for (int i = 0; i < m; i++) {
      if (board[i][n - 1] == 'O' && !visited[i][n - 1]) {
        dfs(i, n - 1, m, n, visited, board);
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] != '*') {
          board[i][j] = 'X';
        }else{
          board[i][j] = 'O';
        }
      }
    }
  }

  private void dfs(int row, int col, int totalRows, int totalCols, boolean[][] visited,
      char[][] board) {

    if (row < 0 || row >= totalRows || col < 0 || col >= totalCols || board[row][col] == 'X'
        || visited[row][col]) {
      return;
    }

    visited[row][col] = true;
    board[row][col] = '*';
    dfs(row + 1, col, totalRows, totalCols, visited, board);
    dfs(row - 1, col, totalRows, totalCols, visited, board);
    dfs(row, col + 1, totalRows, totalCols, visited, board);
    dfs(row, col - 1, totalRows, totalCols, visited, board);
  }

  @Test
  public void test1() {
    char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X'}};
    solve(board);
  }

}
