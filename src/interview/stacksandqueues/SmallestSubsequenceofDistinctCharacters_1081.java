package interview.stacksandqueues;

import java.util.Stack;

public class SmallestSubsequenceofDistinctCharacters_1081 {

  public String smallestSubsequence(String s) {
    int[] charMap = new int[26];

    for (int i = 0; i < s.length(); i++) {
      charMap[s.charAt(i) - 'a']++;
    }

    Stack<Character> stack = new Stack<>();

    boolean[] visited = new boolean[26];

    for (int i = 0; i < s.length(); i++) {
      char currChar = s.charAt(i);
      charMap[s.charAt(i) - 'a']--;
      if (!visited[currChar - 'a']) {
        while (!stack.isEmpty() && stack.peek() > currChar && charMap[stack.peek() - 'a'] != 0) {
          visited[stack.peek() - 'a'] = false;
          stack.pop();
        }
        visited[currChar - 'a'] = true;
        stack.push(currChar);
      }

    }

    StringBuilder stringBuilder = new StringBuilder();

    while (!stack.isEmpty()) {
      stringBuilder.append(stack.pop());
    }

    return stringBuilder.reverse().toString();
  }
}
