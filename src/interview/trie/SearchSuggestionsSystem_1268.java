package interview.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchSuggestionsSystem_1268 {

  class TrieNode {

    private boolean endOfWord;
    private Map<Character, TrieNode> children;

    public TrieNode() {
      this.endOfWord = false;
      children = new TreeMap<>();
    }
  }


  TrieNode root = new TrieNode();


  private void insert(String word) {
    insertRecursively(word, 0, root);
  }

  private void insertRecursively(String word, int index, TrieNode root) {
    if (index == word.length()) {
      root.endOfWord = true;
      return;
    }

    TrieNode child = root.children.get(word.charAt(index));

    if (child == null) {
      child = new TrieNode();
      root.children.put(word.charAt(index), child);
    }

    insertRecursively(word, index + 1, child);
  }


  private void searchByPrefix(String prefix, TrieNode root, List<String> result,
      String currentString, int prefixIndex) {
    if (root.endOfWord && prefix.length() == prefixIndex) {
      result.add(currentString);
    }

    if (prefixIndex < prefix.length()) {
      final char character = prefix.charAt(prefixIndex);
      TrieNode current = root.children.get(character);
      if (current == null) {
        return;
      }
      searchByPrefix(prefix, current, result, currentString + character, prefixIndex + 1);
    } else {
      for (char character : root.children.keySet()) {
        if (result.size() == 3) {
          return;
        }
        searchByPrefix(prefix, root.children.get(character), result, currentString + character,
            prefixIndex);
      }
    }


  }

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    List<List<String>> resultsList = new ArrayList<>();
    for (String product : products) {
      insert(product);
    }

    for (int i = 0; i < searchWord.length(); i++) {
      List<String> result = new ArrayList<>();
      searchByPrefix(searchWord.substring(0, i + 1), root, result, "", 0);
      resultsList.add(result);
    }

    return resultsList;
  }

}
