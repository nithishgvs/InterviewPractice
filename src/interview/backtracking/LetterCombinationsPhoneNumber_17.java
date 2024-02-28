package interview.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber_17 {

  List<String> combinations = new ArrayList<>();
  Map<Character, String> phoneMap = Map
      .of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9',
          "wxyz");

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return combinations;
    }
    helper(digits, new StringBuilder(), 0);
    return combinations;
  }

  public void helper(String digits, StringBuilder partialString, int index) {
    if (partialString.length() == digits.length()) {
      combinations.add(partialString.toString());
      return;
    }
    Character character = digits.charAt(index);
    String phoneMappedChars = phoneMap.get(character);

    for (int i = 0; i < phoneMappedChars.length(); i++) {
      partialString.append(phoneMappedChars.charAt(i));
      helper(digits, partialString, index + 1);
      partialString.deleteCharAt(partialString.length() - 1);
    }

  }

}
