package interview.arrays;

public class ShortestWordDistance_243 {

  public int shortestDistance(String[] wordsDict, String word1, String word2) {
    int shortestDistance = Integer.MAX_VALUE;

    int word1Index = -1;
    int word2Index = -1;

    for (int i = 0; i < wordsDict.length; i++) {
      String word = wordsDict[i];
      if (word1.equals(word)) {
        if (word2Index != -1) {
          shortestDistance = Math.min(shortestDistance, Math.abs(i - word2Index));
        }
        word1Index = i;

      } else if (word2.equals(word)) {
        if (word1Index != -1) {
          shortestDistance = Math.min(shortestDistance, Math.abs(i - word1Index));
        }
        word2Index = i;
      }
    }

    return shortestDistance;
  }
}
