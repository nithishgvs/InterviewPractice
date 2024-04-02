package interview.arrays;

public class TicTacToe {


  int[] rows;
  int[] cols;
  int diagonal1;
  int diagonal2;
  int n;

  public TicTacToe(int n) {
    this.n = n;
    rows = new int[n];
    cols = new int[n];
    diagonal1 = 0;
    diagonal2 = 0;
  }

  public int move(int row, int col, int player) {

    if (player == 1) {
      ++rows[row];
      ++cols[col];

      if (row == col) {
        diagonal1++;
      }
      if (row + col == n - 1) {
        diagonal2++;
      }

      if (rows[row] == n || cols[col] == n || diagonal2 == n
          || diagonal1 == n) {
        return 1;
      }
    } else {
      --rows[row];
      --cols[col];

      if (row == col) {
        diagonal1--;
      }
      if (row + col == n - 1) {
        diagonal2--;
      }

      if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal2) == n
          || Math.abs(diagonal1) == n) {
        return 2;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    /**
     * [[3],[0,0,1],[0,2,2],[2,2,1],[1,1,2],[2,0,1],[1,0,2],[2,1,1]]
     */

    TicTacToe ticTacToe = new TicTacToe(3);
    ticTacToe.move(0, 0, 1);
    ticTacToe.move(0, 2, 2);
    ticTacToe.move(2, 2, 1);
    ticTacToe.move(1, 1, 2);
    ticTacToe.move(2, 0, 1);
    ticTacToe.move(1, 0, 2);
    ticTacToe.move(2, 1, 1);

  }
}
