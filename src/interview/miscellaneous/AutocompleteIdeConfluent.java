package interview.miscellaneous;

import java.util.*;

public class AutocompleteIdeConfluent {

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
      current.childFunctions.add(functionName);
    }
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

    System.out.println(fm.getMatches("R")); // Output: ["ResumePanel", "RidePrinter"]
    System.out.println(fm.getMatches("Re")); // Output: ["ResumePanel"]
    System.out.println(fm.getMatches("RP")); // Output: ["ResumePanel", "RidePrinter"]
    System.out.println(fm.getMatches("RPr")); // Output: ["RidePrinter"]
  }
}

