package interview.backtracking;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators_282 {

  List<String> result = new ArrayList<>();

  public List<String> addOperators(String num, int target) {
    //T/S: O(n4ⁿ)/O(n)
    //https://www.youtube.com/watch?v=tunRDBsP7OQ
    dfs(0, "", 0, 0, target, num);
    return result;
  }


  void dfs(int index, String currentResult, long currentSum, long previousSum, int target,
      String num) {
    if (index >= num.length()) {
      if (currentSum == target) {
        result.add(currentResult);
        return;
      }
    }

    for (int i = index; i < num.length(); i++) {
      if (i != index && num.charAt(index) == '0') {
        break;
      }
      String currentString = num.substring(index, i + 1);
      long currentNumber = Long.parseLong(currentString);
      //Empty string so we need to just append the first number
      if (index == 0) {
        //Current value and previous value will be same in this case
        dfs(i + 1, currentString, currentNumber, currentNumber, target, num);
      } else {
        //If we have 1 earlier this becomes 1+2 if num is 123 + case
        dfs(i + 1, currentResult + "+" + currentString, currentSum + currentNumber, currentNumber,
            target, num);
        //Negative case
        dfs(i + 1, currentResult + "-" + currentString, currentSum - currentNumber, -currentNumber,
            target, num);

        //Multiplication case we need to undo the results because * operator takes precedence 1+2*3 scenario the previous value will be 3*3 it is supposed to be 7
        //1+2*3 case previous value will be 2 and currSum will be 3 currSum-previous will be 3-2 =>1 now currNum*prev 3*2 plus 1
        dfs(i + 1, currentResult + "*" + currentString,
            currentSum - previousSum + previousSum * currentNumber, currentNumber * previousSum,
            target, num);

      }
    }
  }

}
