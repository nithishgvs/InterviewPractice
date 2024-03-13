package interview.twopointers;

public class ValidWordAbbreviation_408 {

  public boolean validWordAbbreviation(String word, String abbr) {
    int startW = 0;
    int startA = 0;

    while (startW < word.length() && startA < abbr.length()) {

      if (word.charAt(startW) == abbr.charAt(startA)) {
        startW++;
        startA++;
        continue;
      }

      if (abbr.charAt(startA) == '0' || !Character.isDigit(abbr.charAt(startA))) {
        return false;
      }

      //abbr encountered a digit
      StringBuilder stringBuilder = new StringBuilder();
      while (startA < abbr.length() && Character.isDigit(abbr.charAt(startA))) {
        stringBuilder.append(abbr.charAt(startA));
        startA++;
      }

      startW += Integer.valueOf(stringBuilder.toString());
    }

    return startW == word.length() && startA == abbr.length();
  }
}
