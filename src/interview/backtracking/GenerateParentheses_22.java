package interview.backtracking;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GenerateParentheses_22 {

  //Back to back Swe solution
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    directedGenerateBalancedParentheses(n, n, "", result);
    return result;
  }

  private void directedGenerateBalancedParentheses(int numLeftParensNeeded,
      int numRightParensNeeded,
      String parenStringInProgress,
      List<String> result) {

    if (numLeftParensNeeded == 0 && numRightParensNeeded == 0) {
      result.add(parenStringInProgress);
      return;
    }
    if (numLeftParensNeeded > 0) {
      directedGenerateBalancedParentheses(numLeftParensNeeded - 1, numRightParensNeeded,
          parenStringInProgress + "(", result);
    }
    if (numLeftParensNeeded < numRightParensNeeded) {
      directedGenerateBalancedParentheses(numLeftParensNeeded, numRightParensNeeded - 1,
          parenStringInProgress + ")", result);
    }
  }

  @Test
  public void test() {
    generateParenthesis(3).forEach(s->System.out.println(s));
  }
}
