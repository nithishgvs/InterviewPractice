package interview.arrays;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PascalsTriangle_118 {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows == 0) {
      return result;
    }

    result.add(List.of(1));

    for (int i = 1; i < numRows; i++) {
      List<Integer> previousList = result.get(i - 1);
      List<Integer> newList = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        int index1 = j - 1 < 0 ? 0 : previousList.get(j - 1);
        int index2 = j >= previousList.size() ? 0 : previousList.get(j);
        newList.add(index1 + index2);
      }
      result.add(newList);
    }

    return result;
  }

  @Test
  public void test(){
    generate(5);
  }

}
