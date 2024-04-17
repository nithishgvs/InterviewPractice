package interview.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class MetaTrieProblem {

  //https://leetcode.com/discuss/interview-question/5028919/Meta-E5-Phone-Screen-Waiting-for-results/

  /**
   * Time and Space Complexities The time complexity for creating a Trie is O(WL), where W is the
   * number of words, and L is an average length of the word. This is because, for each word, we are
   * traversing down the path that corresponds to each character in the word, so in total, the
   * runtime comes out to be O(WL). In terms of space complexity, since we are storing all the W
   * words of average length L in the Trie, the space complexity also comes out to be O(W*L).
   */
  class TrieNode {

    boolean isEndOfWord;
    Map<Character, TrieNode> children;

    public TrieNode() {
      this.isEndOfWord = false;
      this.children = new HashMap<>();
    }
  }

  TrieNode root = new TrieNode();

  public void insert(String word) {
    insertRecursively(word, 0, root);
  }

  private void insertRecursively(String word, int index, TrieNode root) {
    if (index == word.length()) {
      root.isEndOfWord = true;
      return;
    }
    Character ch = word.charAt(index);

    TrieNode trieNode = root.children.get(ch);

    if (trieNode == null) {
      trieNode = new TrieNode();
      root.children.put(ch, trieNode);
    }
    insertRecursively(word, ++index, trieNode);
  }

  private boolean searchPrefix(String word) {
    return searchRecursively(word, 0, root);
  }

  private boolean searchRecursively(String word, int index, TrieNode root) {
    if (root.isEndOfWord) {
      return true;
    }

    Character ch = word.charAt(index);

    TrieNode trieNode = root.children.get(ch);

    if (trieNode == null) {
      return false;
    }

    return searchRecursively(word, ++index, trieNode);
  }


  @Test
  public void test() {
    String[] words = new String[]{"foodie", "food", "foo", "bar", "baz"};

    Arrays.sort(words, Comparator.comparingInt(String::length));

    List<String> result = new ArrayList<>();

    for (String word : words) {
      if (!searchPrefix(word)) {
        insert(word);
        result.add(word);
      }
    }

    result.forEach(val -> System.out.println(val));
  }


}
