package interview.hashmap;

public class RansomNote_383 {


  public boolean canConstruct(String ransomNote, String magazine) {

    int[] mArr = new int[26];

    for (char c : magazine.toCharArray()) {
      mArr[c - 'a']++;
    }

    for (char c : ransomNote.toCharArray()) {
      if (mArr[c - 'a'] <= 0) {
        return false;
      }
      mArr[c - 'a']--;
    }

    return true;
  }
}
