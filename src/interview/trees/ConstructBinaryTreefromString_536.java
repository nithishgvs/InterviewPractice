package interview.trees;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.Test;

public class ConstructBinaryTreefromString_536 {


  public TreeNode str2tree(String s) {
    return dfs(s);
  }

  private TreeNode dfs(String s) {
    if (s.isEmpty()) {
      return null;
    }

    int index = s.indexOf("(");

    if (index == -1) {
      return new TreeNode(Integer.valueOf(s));
    }

    TreeNode root = new TreeNode(Integer.valueOf(s.substring(0, index)));

    int count = 0;

    int start = index;

    for (int i = index; i < s.length(); i++) {

      char ch = s.charAt(i);

      if (ch == '(') {
        count++;
      } else if (ch == ')') {
        count--;
      }

      if (count == 0) {
        if (start == index) {
          root.left = dfs(s.substring(start + 1, i));
          start = i + 1;
        } else {
          root.right = dfs(s.substring(start + 1, i));
        }
      }

    }

    return root;
  }


  @Test
  public void test() {
    String s = "4(2(3)(1))";//(6(5))
    TreeNode root = str2tree(s);
    System.out.println(root);
  }
}
