package interview.trie;


import java.util.HashMap;
import java.util.Map;


public class WordDictionary {

  public class TrieNode {

    private boolean endOfWord;
    private Map<Character, TrieNode> children;

    public TrieNode() {
      this.endOfWord = false;
      this.children = new HashMap<>();
    }
  }

  private TrieNode root;

  public void insertRecursive(String word) {
    insertHelper(word, 0, root);
  }

  private void insertHelper(String word, int index, TrieNode trieNode) {
    if (index == word.length()) {
      trieNode.endOfWord = true;
      return;
    }
    final char ch = word.charAt(index);
    TrieNode node = trieNode.children.get(ch);

    if (node == null) {
      node = new TrieNode();
      trieNode.children.put(ch, node);
    }
    insertHelper(word, ++index, node);
  }

  public boolean searchRecursive(String word) {
    return searchHelper(word, 0, root);
  }

  private boolean searchHelper(String word, int index, TrieNode trieNode) {
    if (word.length() == index) {
      return trieNode.endOfWord;
    }
    final char ch = word.charAt(index);
    if (ch == '.') {
      Map<Character, TrieNode> children = trieNode.children;
      for (Map.Entry<Character, TrieNode> entry : children.entrySet()) {
        final boolean found = searchHelper(word, index+1, entry.getValue());
        if (found) {
          return true;
        }
      }
    }
    TrieNode node = trieNode.children.get(ch);
    if (node == null) {
      return false;
    }
    return searchHelper(word, ++index, node);
  }

  public WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    insertRecursive(word);
  }

  public boolean search(String word) {
    return searchRecursive(word);
  }

  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("mad");
    wordDictionary.addWord("pad");
    System.out.println(wordDictionary.search("bad"));
    System.out.println(wordDictionary.search(".ad"));
    System.out.println(wordDictionary.search("b.."));
    System.out.println(wordDictionary.search("b..."));
  }

}
