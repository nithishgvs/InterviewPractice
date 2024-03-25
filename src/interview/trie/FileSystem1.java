package interview.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FileSystem1 {
  //1166. Design File System

  class TrieNode {

    boolean endOFWord;
    int value;

    Map<Character, TrieNode> children;

    public TrieNode() {
      this.endOFWord = false;
      value = -1;
      children = new HashMap<>();
    }
  }

  class Pair {

    Integer value;
    Boolean endOfWord;

    public Pair(Integer value, Boolean endOfWord) {
      this.value = value;
      this.endOfWord = endOfWord;
    }
  }


  TrieNode root;


  private void insert(String string, int value) {
    insertRecursively(root, string, value, 0);
  }


  private Pair searchPrefix(String string) {
    return searchRecursively(root, string, 0);
  }

  private Pair searchRecursively(TrieNode root, String string, int index) {
    if (string.length() == index) {
      return new Pair(root.value, root.endOFWord);
    }

    TrieNode node = root.children.get(string.charAt(index));
    if (node == null) {
      return null;
    }

    return searchRecursively(node, string, ++index);
  }

  private void insertRecursively(TrieNode root, String string, int value, int index) {
    if (index == string.length()) {
      root.endOFWord = true;
      root.value = value;
      return;
    }

    TrieNode node = root.children.get(string.charAt(index));

    if (node == null) {
      node = new TrieNode();
      root.children.put(string.charAt(index), node);
    }

    insertRecursively(node, string, value, ++index);
  }

  public FileSystem1() {
    root = new TrieNode();
  }

  public boolean createPath(String path, int value) {

    //First split the paths by / delimitter
    String[] paths = path.split("\\/", -1);
    paths = Arrays.stream(paths)
        .filter(s -> !s.isEmpty())
        .toArray(String[]::new);
    //If paths contain multiple parent paths we first decide if they exist and then insert it
    if (paths.length > 1) {
      String toBeInserted = String.join("|", Arrays.copyOf(paths, paths.length - 1));
      Pair result = searchPrefix(toBeInserted + "|");
      if (result == null) {
        return false;
      }
      if (!result.endOfWord) {
        return false;
      }
    }
    //Check duplicate path exists
    String toBeInserted = String.join("|", Arrays.copyOf(paths, paths.length)) + "|";
    Pair result = searchPrefix(toBeInserted);
    if (result == null) {
      insert(toBeInserted, value);
      return true;
    }

    return false;
  }

  public int get(String path) {
    //First split the paths by / delimitter
    String[] paths = path.split("\\/", -1);
    paths = Arrays.stream(paths)
        .filter(s -> !s.isEmpty())
        .toArray(String[]::new);
    String toBeChecked = String.join("|", paths) + "|";
    Pair result = searchPrefix(toBeChecked);
    if (result == null) {
      return -1;
    }
    return result.value;
  }

}
