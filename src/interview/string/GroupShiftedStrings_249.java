package interview.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class GroupShiftedStrings_249 {


  public List<List<String>> groupStrings(String[] strings) {

    List<List<String>> result = new ArrayList<>();

    Map<String, List<String>> map = new HashMap<>();

    for (String str : strings) {

      StringBuilder stringBuilder = new StringBuilder();

      for (int i = 1; i < str.length(); i++) {
        int current = str.charAt(i) - 'a';
        int previous = str.charAt(i - 1) - 'a';
        //Floor mod for positive gives remainder 1%26 is 1
        //For negative it rounds up -19%26 is -19 it adds +26 => -19+26 = 7
        stringBuilder.append(Math.floorMod(current - previous, 26)).append("|");
      }
      if (!map.containsKey(stringBuilder.toString())) {
        map.put(stringBuilder.toString(), new ArrayList<>());
      }
      map.get(stringBuilder.toString()).add(str);


    }

    map.forEach((k, v) -> result.add(v));

    return result;

  }

  @Test
  public void test() {
    String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z", "al"};
    groupStrings(strings);
  }


}
