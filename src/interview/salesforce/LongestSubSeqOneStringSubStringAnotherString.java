package interview.salesforce;

public class LongestSubSeqOneStringSubStringAnotherString {

  /**
   * Input: X = “ABCD”, Y = “ACDBDCD”
   * Output: ACD
   * Explanation:
   * “ACD” is longest subsequence of X which is substring of Y.
   *
   * Input: X = A, Y = A
   * Output: A
   */

  public static String longestSubsequence(
      String X, String Y)
  {

    // Stores the lengths of strings
    // X and Y
    int n = X.length();
    int m = Y.length();

    // Create a matrix
    int[][] mat = new int[n + 1][m + 1];

    // Initialize the matrix
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0)
          mat[i][j] = 0;
      }
    }

    // Fill all the remaining rows
    for (int i = 1;
        i < n + 1; i++) {

      for (int j = 1;
          j < m + 1; j++) {

        // If the characters are equal
        if (X.charAt(i - 1)
            == Y.charAt(j - 1)) {
          mat[i][j] = 1
              + mat[i - 1][j - 1];
        }

        // If not equal, then
        // just move to next
        // in subsequence string
        else {
          mat[i][j] = mat[i - 1][j];
        }
      }
    }

    // Find maximum length of the
    // longest subsequence matching
    // substring of other string
    int len = 0, col = 0;

    // Iterate through the last
    // row of matrix
    for (int i = 0; i < m + 1; i++) {

      if (mat[n][i] > len) {
        len = mat[n][i];
        col = i;
      }
    }

    // Store the required string
    String res = "";
    int i = n;
    int j = col;

    // Backtrack from the cell
    while (len > 0) {

      // If equal, then add the
      // character to res string
      if (X.charAt(i - 1)
          == Y.charAt(j - 1)) {

        res = X.charAt(i - 1) + res;
        i--;
        j--;
        len--;
      }
      else {
        i--;
      }
    }

    // Return the required string
    return res;
  }

  // Driver Code
  public static void main(String args[])
  {
    String X = "ABCD";
    String Y = "ACDBDCD";
    System.out.println(
        longestSubsequence(X, Y));
  }
}
