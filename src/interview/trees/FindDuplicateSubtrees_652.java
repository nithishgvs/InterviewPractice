package interview.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class FindDuplicateSubtrees_652 {

  List<TreeNode> res = new ArrayList<>();

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<String, Integer> visited = new HashMap<>();
    helper(visited, root);
    return res;
  }

  private String helper(Map<String, Integer> visited, TreeNode root) {
    String newString;
    if (root == null) {
      return "";
    }
    newString = "l" + helper(visited, root.left) + root.val + "r" + helper(visited, root.right);

    if (!visited.containsKey(newString)) {
      visited.put(newString, 1);
    } else {
      if (visited.get(newString) == 1) {
        res.add(root);
      }
      visited.put(newString, visited.get(newString) + 1);
    }

    return newString;

  }


  @Test
  public void test() {
    TreeNode root = new HelperTree()
        .generateBinaryTree(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, 4});
    System.out.println(findDuplicateSubtrees(root));
  }

}
