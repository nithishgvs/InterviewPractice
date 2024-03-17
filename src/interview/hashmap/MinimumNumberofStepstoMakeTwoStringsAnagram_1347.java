package interview.hashmap;

public class MinimumNumberofStepstoMakeTwoStringsAnagram_1347 {


  public int minSteps(String s, String t) {

    int[] freq = new int[26];

    for (char chars : s.toCharArray()) {
      freq[chars - 'a']++;
    }
    int steps = 0;

    for (char chars : t.toCharArray()) {
      if (freq[chars - 'a'] == 0) {
        steps++;
      } else {
        freq[chars - 'a']--;
      }
    }

    return steps;

  }

}
