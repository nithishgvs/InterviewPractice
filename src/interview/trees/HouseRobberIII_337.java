package interview.trees;

import javafx.util.Pair;
import org.junit.Test;

public class HouseRobberIII_337 {


    public int rob(TreeNode root) {

        //We maintain a Pair object with max value with currentNode root and without currentNode root

        Pair<Integer, Integer> pair = dfs(root);
        return Math.max(pair.getKey(), pair.getValue());

    }

    private Pair<Integer, Integer> dfs(TreeNode root) {

        if (root == null)
            return new Pair<>(0, 0);

        Pair<Integer, Integer> left = dfs(root.left);
        Pair<Integer, Integer> right = dfs(root.right);

        //Key value will have with root Value without root

        Integer withRootValue = root.val + left.getValue() + right.getValue();
        Integer withoutRootValue = Math.max(left.getKey(), left.getValue()) + Math.max(right.getKey(), right.getValue());
        return new Pair<>(withRootValue, withoutRootValue);
    }


    @Test
    public void test() {
        TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{4, 1, null, 2, null, 3});
        System.out.println(rob(root));
    }

}
