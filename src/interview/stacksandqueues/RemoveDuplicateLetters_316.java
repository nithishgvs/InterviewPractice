package interview.stacksandqueues;

import java.util.HashSet;
import java.util.Stack;
import org.junit.Test;

public class RemoveDuplicateLetters_316 {


  public String removeDuplicateLetters(String s) {

    int[] charFreq = new int[26];

    for (char ch : s.toCharArray()) {
      charFreq[ch - 'a']++;
    }

    StringBuilder stringBuilder = new StringBuilder();

    boolean[] visited = new boolean[26];

    Stack<Character> stack = new Stack<>();


    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      charFreq[ch - 'a']--;
      if (visited[ch - 'a']) {
        continue;
      }
      while (!stack.isEmpty() && stack.peek() > ch && charFreq[stack.peek() - 'a'] != 0) {
        char popped = stack.pop();
        visited[popped - 'a'] = false;
      }
      stack.push(ch);
      visited[ch - 'a'] = true;
    }

    while (!stack.isEmpty()) {
      stringBuilder.append(stack.pop());
    }

    return stringBuilder.reverse().toString();
  }

  @Test
  public void test() {
    System.out.println(removeDuplicateLetters("bcabc"));
  }

}
