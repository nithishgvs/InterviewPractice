package interview.hashmap;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PartitionLabels_763 {


  public List<Integer> partitionLabels(String s) {
    List<Integer> res = new ArrayList<>();

    int[] arr = new int[26];

    for (int i = 0; i < s.length(); i++) {
      arr[s.charAt(i) - 'a'] = i;
    }

    int startIndex = 0;
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
      startIndex = Math.max(startIndex, arr[s.charAt(i) - 'a']);
      if (startIndex == i) {
        res.add(startIndex - start + 1);
        start = i;
      }
    }

    return res;
  }


  @Test
  public void tst() {
    partitionLabels("ababcbacadefegdehijhklij");
  }

}
