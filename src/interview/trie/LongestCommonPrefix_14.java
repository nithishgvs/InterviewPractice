package interview.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class LongestCommonPrefix_14 {

  public class TrieNode {

    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
      this.children = new HashMap<>();
      this.endOfWord = false;
    }
  }

  TrieNode root = new TrieNode();

  public void insertTrie(String word) {
    insertRecursively(root, 0, word);
  }

  private void insertRecursively(TrieNode root, int index, String word) {
    if (index == word.length()) {
      root.endOfWord = true;
      return;
    }
    char ch = word.charAt(index);
    TrieNode node = root.children.get(ch);

    if (node == null) {
      node = new TrieNode();
      root.children.put(ch, node);
    }
    insertRecursively(node, ++index, word);
  }


  public String longestCommonPrefix(String[] strs) {
    for (String str : strs) {
      insertTrie(str);
    }
    return longestPrefixHelper(root);

  }

  private String longestPrefixHelper(TrieNode root) {
    StringBuilder stringBuilder = new StringBuilder();
    TrieNode current = root;

    while (current.children.size() == 1 && !current.endOfWord) {
      Set<Character> keySet = current.children.keySet();
      for (Character key : keySet) {
        stringBuilder.append(key);
        current = current.children.get(key);
      }
    }

    return stringBuilder.toString();
  }


  @Test
  public void test() {
    String[] strs = {"ab", "a"};
    longestCommonPrefix(strs);
  }


}
