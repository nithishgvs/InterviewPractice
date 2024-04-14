package interview.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class RemoveInvalidParentheses_301 {

  Set<String> result = new HashSet<>();
  int longestString = 0;

  public List<String> removeInvalidParentheses(String s) {
    //https://www.youtube.com/watch?v=wtoNj0d-OEI
    dfs(s, 0, new StringBuilder(), 0, 0);
    return new ArrayList<>(result);
  }

  private void dfs(String s, int index, StringBuilder currentResult, int leftParenthesisCount,
      int rightParenthesisCount) {

    if (index >= s.length()) {
      if (leftParenthesisCount == rightParenthesisCount) {
        if (currentResult.length() > longestString) {
          longestString = currentResult.length();
          result.clear();
          result.add(currentResult.toString());
        } else if (currentResult.length() == longestString) {
          result.add(currentResult.toString());
        }
      }
      return;
    }

    char currentChar = s.charAt(index);

    if (currentChar == '(') {
      //Here we have 2 cases either take it or dont take it as we dont know if there is a right parenthesis after it
      currentResult.append(currentChar);
      dfs(s, index + 1, currentResult, leftParenthesisCount + 1, rightParenthesisCount);
      //Removing last Character
      currentResult.deleteCharAt(currentResult.length() - 1);
      dfs(s, index + 1, currentResult, leftParenthesisCount, rightParenthesisCount);
    } else if (currentChar == ')') {
      //Ignore the currentChar ) scenario
      dfs(s, index + 1, currentResult, leftParenthesisCount, rightParenthesisCount);
      //Here we can move only if  leftCount>rightCount for include scenario
      if (leftParenthesisCount > rightParenthesisCount) {
        currentResult.append(currentChar);
        dfs(s, index + 1, currentResult, leftParenthesisCount, rightParenthesisCount + 1);
        //Removing last Character
        currentResult.deleteCharAt(currentResult.length() - 1);
      }
    } else {
      //Non braces scenario
      currentResult.append(currentChar);
      dfs(s, index + 1, currentResult, leftParenthesisCount, rightParenthesisCount);
      currentResult.deleteCharAt(currentResult.length() - 1);
    }
  }

  @Test
  public void test() {
    removeInvalidParentheses(")(f");
  }

}
