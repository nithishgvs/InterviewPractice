package interview.string;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();

    Map<String, List<String>> helperMap = new HashMap<>();

    for (String str : strs) {
      char[] array = str.toCharArray();
      Arrays.sort(array);
      final String stringKey = String.valueOf(array);
      if (!helperMap.containsKey(stringKey)) {
        helperMap.put(stringKey, new ArrayList<>());
      }
      helperMap.get(stringKey).add(str);
    }

    helperMap.forEach((key, value) -> {
      result.add(value);
    });

    return result;
  }
}
