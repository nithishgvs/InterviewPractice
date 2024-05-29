package interview.arrays;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class ValidSudoku_36 {


  public boolean isValidSudoku(char[][] board) {
    Set<String> visited = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {

        if (board[i][j] != '.') {
          String seenRow = "Seen " + board[i][j] + " in " + i + ""
              + " row";

          String seenCol = "Seen " + board[i][j] + " in " + j + ""
              + " col";

          String seenGrid = "Seen " + board[i][j] + " in " + i / 3 + " and"
              + j / 3 + " grid";

          if (visited.contains(seenRow) || visited.contains(seenCol) || visited
              .contains(seenGrid)) {
            return false;
          }

          visited.add(seenCol);
          visited.add(seenRow);
          visited.add(seenGrid);
        }
      }
    }

    return true;
  }


  @Test
  public void test() {
    char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
        , {'.', '9', '5', '.', '.', '.', '.', '6', '.'}
        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    System.out.println(isValidSudoku(board));
  }

}
