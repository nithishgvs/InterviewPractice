package interview.hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Codec {

  Map<String, List<String>> encodeMap = new HashMap<>();

  // Encodes a list of strings to a single string.

  public String encode(List<String> strs) {
    StringBuilder stringBuilder = new StringBuilder();
    strs.forEach(string -> stringBuilder.append(string).append("|"));
    String encodedKey = stringBuilder.substring(0, stringBuilder.length() - 1);
    encodeMap.put(encodedKey, strs);
    return encodedKey;
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    return encodeMap.get(s);
  }
}

