package interview.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class RepeatedDNASequences_187 {


  public List<String> findRepeatedDnaSequences(String s) {
    Set<String> set = new HashSet<>();

    Set<String> res = new HashSet<>();

    for (int i = 0; i < s.length() - 9; i++) {
      String temp = s.substring(i, i + 10);
      if (!set.contains(temp)) {
        set.add(temp);
      } else {
        res.add(temp);
      }
    }

    return new ArrayList<>(res);
  }

  @Test
  public void test() {
    System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
  }

}
