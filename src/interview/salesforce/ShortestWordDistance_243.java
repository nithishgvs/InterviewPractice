package interview.salesforce;

import org.junit.Test;

public class ShortestWordDistance_243 {


  public int shortestDistance(String[] wordsDict, String word1, String word2) {

    int shortestDist = Integer.MAX_VALUE;

    int word1Index = -1;
    int word2Index = -1;

    for (int i = 0; i < wordsDict.length; i++) {

      if (word1.equals(wordsDict[i])) {
        word1Index = i;
      } else if (word2.equals(wordsDict[i])) {
        word2Index = i;
      }

      if (word1Index != -1 && word2Index != -1) {
        shortestDist = Math.min(shortestDist, Math.abs(word1Index - word2Index));
      }

    }

    return shortestDist;

  }

  @Test
  public void test() {
    String[] dict = {"practice", "makes", "perfect", "coding", "makes"};
    System.out.println(shortestDistance(dict, "makes", "coding"));
  }


}
