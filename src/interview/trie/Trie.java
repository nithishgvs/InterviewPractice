package interview.trie;


import java.util.HashMap;
import java.util.Map;


public class Trie {

  class TrieNode {

    boolean endOfWord;
    Map<Character, TrieNode> children;

    public TrieNode() {
      this.endOfWord = false;
      this.children = new HashMap<>();
    }
  }

  TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    insertRecursive(word, 0, root);
  }

  private void insertRecursive(String word, int index, TrieNode currentNode) {
    if (index == word.length()) {
      currentNode.endOfWord = true;
      return;
    }

    char ch = word.charAt(index);
    TrieNode child = currentNode.children.get(ch);

    if (child == null) {
      child = new TrieNode();
      currentNode.children.put(ch, child);
    }
    currentNode = child;
    insertRecursive(word, index + 1, currentNode);
  }

  public boolean search(String word) {
    return searchRecursive(word, root, 0);
  }

  private boolean searchRecursive(String word, TrieNode currentNode, int index) {
    if (index == word.length()) {
      return currentNode.endOfWord;
    }
    char ch = word.charAt(index);
    currentNode = currentNode.children.get(ch);
    if (currentNode == null) {
      return false;
    }
    return searchRecursive(word, currentNode, index + 1);
  }

  public boolean startsWith(String prefix) {
    return findPrefixExists(prefix, root, 0);
  }

  private boolean findPrefixExists(String word, TrieNode currentNode, int index) {
    if (index == word.length()) {
      return true;
    }
    char ch = word.charAt(index);
    currentNode = currentNode.children.get(ch);
    if (currentNode == null) {
      return false;
    }
    return findPrefixExists(word, currentNode, index + 1);
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    System.out.println(trie.search("apple"));
    System.out.println(trie.search("app"));
    System.out.println(trie.startsWith("app"));
    trie.insert("app");
    System.out.println(trie.search("app"));
  }
}
