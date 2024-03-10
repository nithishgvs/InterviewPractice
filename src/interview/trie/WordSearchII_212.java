package interview.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class WordSearchII_212 {

  //Return result
  Set<String> result = new HashSet<>();

  TrieNode root;

  class TrieNode {

    private Map<Character, TrieNode> children;
    private boolean endOFWord;

    public TrieNode() {
      this.children = new HashMap<>();
      this.endOFWord = false;
    }
  }

  class Trie {

    public Trie() {
      root = new TrieNode();
    }

    public void insert(String word) {
      insertRecursively(root, word, 0);
    }

    private void insertRecursively(TrieNode root, String word, int index) {
      if (index == word.length()) {
        root.endOFWord = true;
        return;
      }
      char ch = word.charAt(index);
      TrieNode trieNode = root.children.get(ch);
      if (trieNode == null) {
        trieNode = new TrieNode();
        root.children.put(ch, trieNode);
      }
      insertRecursively(trieNode, word, ++index);
    }
  }


  public List<String> findWords(char[][] board, String[] words) {

    //Construct trie data structure of words
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }

    boolean[][] visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        wordSearchHelper(i, j, visited, board, root, "");
      }
    }

    return new ArrayList<>(result);

  }

  private void wordSearchHelper(int row, int col, boolean[][] visited, char[][] board,
      TrieNode root, String currentWord) {
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
      return;
    }

    if (root.children.containsKey(board[row][col])) {
      visited[row][col] = true;
      TrieNode trieNode = root.children.get(board[row][col]);
      if (trieNode.endOFWord == true) {
        result.add(currentWord + board[row][col]);
      }
      wordSearchHelper(row, col - 1, visited, board, trieNode,
          currentWord + (board[row][col]));
      wordSearchHelper(row, col + 1, visited, board, trieNode,
          currentWord + (board[row][col]));
      wordSearchHelper(row - 1, col, visited, board, trieNode,
          currentWord + (board[row][col]));
      wordSearchHelper(row + 1, col, visited, board, trieNode,
          currentWord + (board[row][col]));
      visited[row][col] = false;
    }
  }

  @Test
  public void test() {
    String[] words = {"oa", "oaa"};
    char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}};
    findWords(board, words);
  }

  @Test
  public void test1() {
    String[] words = {"oa", "oaa"};
    char[][] board = {{'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'},
        {'a', 'f', 'l', 'v'}};
    findWords(board, words);
  }
}
