package interview.arrays;

public class CustomSortString_791 {

  public String customSortString(String order, String s) {
    int[] sort = new int[26];

    for (int i = 0; i < s.length(); i++) {
      sort[s.charAt(i) - 'a']++;
    }

    char[] result = new char[s.length()];
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < order.length(); i++) {
      char ch = order.charAt(i);
      while (sort[ch - 'a'] > 0) {
        stringBuilder.append(ch);
        sort[ch - 'a']--;
      }
    }

    for (int i = 0; i < sort.length; i++) {
      while (sort[i] > 0) {
        stringBuilder.append((char) (i + 'a'));
        sort[i]--;
      }
    }

    return stringBuilder.toString();
  }
}
