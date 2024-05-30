package interview.miscellaneous;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Prefix matching find common sentences in multiple files
 */

class TrieNode {
  Map<Character, TrieNode> children = new HashMap<>();
  Set<String> sentences = new HashSet<>();
}

class Trie {
  TrieNode root = new TrieNode();

  void insert(String sentence) {
    insertRecursive(root, sentence, 0);
  }

  private void insertRecursive(TrieNode node, String sentence, int index) {
    if (index == sentence.length()) {
      node.sentences.add(sentence);
      return;
    }
    char ch = sentence.charAt(index);
    node.children.putIfAbsent(ch, new TrieNode());
    insertRecursive(node.children.get(ch), sentence, index + 1);
  }

  Set<String> search(String sentence) {
    return searchRecursive(root, sentence, 0);
  }

  private Set<String> searchRecursive(TrieNode node, String sentence, int index) {
    if (index == sentence.length()) {
      return node.sentences;
    }
    char ch = sentence.charAt(index);
    TrieNode childNode = node.children.get(ch);
    if (childNode == null) {
      return Collections.emptySet();
    }
    return searchRecursive(childNode, sentence, index + 1);
  }
}

public class CommonSentencesFinderConfluent {

  public static Trie buildTrieFromFile(String filename) {
    Trie trie = new Trie();

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] sentences = line.split("\\.");
        for (String sentence : sentences) {
          sentence = sentence.trim();
          if (!sentence.isEmpty()) {
            trie.insert(sentence);
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return trie;
  }

  public static Set<String> findCommonSentences(List<Trie> tries) {
    if (tries.isEmpty()) return Collections.emptySet();
    Set<String> commonSentences = new HashSet<>();

    // Initialize commonSentences with sentences from the first trie
    Trie firstTrie = tries.get(0);
    commonSentences.addAll(getNonEmptySentences(firstTrie.root));

    for (int i = 1; i < tries.size(); i++) {
      Set<String> currentSet = new HashSet<>();
      Trie trie = tries.get(i);
      for (String sentence : commonSentences) {
        currentSet.addAll(trie.search(sentence));
      }
      commonSentences.retainAll(currentSet);
      if (commonSentences.isEmpty()) break;
    }

    return commonSentences;
  }

  private static Set<String> getNonEmptySentences(TrieNode node) {
    Set<String> sentences = new HashSet<>();
    for (String sentence : node.sentences) {
      if (!sentence.isEmpty()) {
        sentences.add(sentence);
      }
    }
    for (TrieNode child : node.children.values()) {
      sentences.addAll(getNonEmptySentences(child));
    }
    return sentences;
  }


  public static void main(String[] args) {
    // List of file paths
    List<String> files = Arrays.asList("file1.txt", "file2.txt", "file3.txt");

    // Build Trie for each file
    List<Trie> tries = files.stream().map(CommonSentencesFinderConfluent::buildTrieFromFile).collect(Collectors.toList());

    // Find common sentences
    Set<String> commonSentences = findCommonSentences(tries);

    // Output common sentences
    System.out.println("Common Sentences:");
    commonSentences.forEach(System.out::println);
  }
}

