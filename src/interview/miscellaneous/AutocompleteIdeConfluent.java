package interview.miscellaneous;

import java.util.*;

public class AutocompleteIdeConfluent {

  /**
   * Time Complexity:
   *
   * Insertion: O(m), where m is the length of the string being inserted. In the worst case, each character in the string needs to be inserted into a new node.
   * Search: O(m), where m is the length of the search prefix. In the worst case, the search might need to traverse the entire path in the Trie corresponding to the prefix.
   * Autocomplete: O(m + k), where m is the length of the search prefix and k is the number of matching suggestions. This considers the search part (O(m)) and the additional time to iterate through matching suggestions (O(k)).
   *
   *
   * Space Complexity:
   *
   * Worst Case: O(Σ |w| * T), where Σ is the size of the alphabet, |w| is the average word length in the dataset, and T is the total number of words in the dataset. This represents the maximum space required to store all possible combinations of characters in the worst case.
   * Average Case: In practice, the space complexity is typically less than the worst case. It depends on the actual data stored and the distribution of characters and words.
   */
  private static class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;
    Set<String> childFunctions;

    public TrieNode() {
      this.children = new HashMap<>();
      this.endOfWord = false;
      this.childFunctions = new HashSet<>();
    }

    @Override
    public String toString() {
      return "endOfWord=" + endOfWord + ", childFunctions=" + childFunctions;
    }
  }

  private final TrieNode root;

  public AutocompleteIdeConfluent() {
    this.root = new TrieNode();
  }

  public void addFunction(String functionName) {
    TrieNode current = root;
    for (char ch : functionName.toCharArray()) {
      current = current.children.computeIfAbsent(ch, k -> new TrieNode());
    }
    current.childFunctions.add(functionName);
    current.endOfWord = true;
  }

  public List<String> getMatches(String input) {
    List<String> result = new ArrayList<>();
    recur(root, input, 0, result);
    return result;
  }

  private void recur(TrieNode node, String input, int index, List<String> result) {
    if (index >= input.length()) {
      collectFunctions(node, result);
      return;
    }

    char currentChar = input.charAt(index);
    TrieNode nextNode = node.children.get(currentChar);

    if (nextNode != null) {
      recur(nextNode, input, index + 1, result);
    }

    if (Character.isUpperCase(currentChar)) {
      for (TrieNode child : node.children.values()) {
        recur(child, input, index, result);
      }
    }
  }

  private void collectFunctions(TrieNode node, List<String> result) {
    if (node.endOfWord) {
      result.addAll(node.childFunctions);
    }
    for (TrieNode child : node.children.values()) {
      collectFunctions(child, result);
    }
  }

  // Example usage
  public static void main(String[] args) {
    AutocompleteIdeConfluent fm = new AutocompleteIdeConfluent();
    fm.addFunction("Container");
    fm.addFunction("Panel");
    fm.addFunction("AutoPanel");
    fm.addFunction("RidePrinter");
    fm.addFunction("ResumePanel");

//    System.out.println(fm.getMatches("R")); // Output: ["ResumePanel", "RidePrinter"]
//    System.out.println(fm.getMatches("Re")); // Output: ["ResumePanel"]
//    System.out.println(fm.getMatches("RP")); // Output: ["ResumePanel", "RidePrinter"]
//    System.out.println(fm.getMatches("RPr")); // Output: ["RidePrinter"]
    System.out.println(fm.getMatches("RZ"));
  }
}

