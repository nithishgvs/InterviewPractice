package interview.salesforce;

public class RemoveAdjacentAlmostEqualCharacters_2957 {

  /**
   * A string is beautiful if no two adjacent characters are • either the same, for example 'aa' •
   * adjacent in the alphabet, for example 'ef'.
   * <p>
   * The following operations can be performed on a string, s. • Choose any index i (0 ≤ i < |s|)
   * and change s[i] to any lowercase English letter.
   * <p>
   * Find the minimum number of operations required to make the string beautiful.
   * <p>
   * Example - s = "abdde" String s is not beautiful because: • 'dd' violates constraint 1, no two
   * adjacent characters are the same. • 'ab' and 'de' violate constraint 2, no two adjacent
   * characters are adjacent in the alphabet.
   * <p>
   * The string can be converted into a beautiful string after 2 operations. One solution is below.
   * • Choose i=1 and change s[i] to 'z'. s becomes "azdde". • Choose i=3 and change s[i] to 'k'. s
   * becomes "azdke" which is beautiful.
   */


  public int removeAlmostEqualCharacters(String word) {

    int res = 0;

    int start = 1;

    while (start < word.length()) {
      if (Math.abs(word.charAt(start - 1) - word.charAt(start)) == 1
          || word.charAt(start - 1) == word.charAt(start)) {
        res++;
        start += 2;
      } else {
        start += 1;
      }
    }

    return res;

  }


}
