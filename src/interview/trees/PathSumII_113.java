package interview.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        dfs(root, targetSum, new ArrayList<>());

        return result;

    }

    private void dfs(TreeNode root, int targetSum, List<Integer> currentList) {
        if (root == null)
            return;
        currentList.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(currentList));
        } else {
            dfs(root.left, targetSum - root.val, new ArrayList<>(currentList));
            dfs(root.right, targetSum - root.val, new ArrayList<>(currentList));
        }
        currentList.remove(currentList.size() - 1);
    }

    @Test
    public void test() {
        TreeNode treeNode = new HelperTree().generateBinaryTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        pathSum(treeNode, 22);
    }

    @Test
    public void test1() {
        TreeNode treeNode = new HelperTree().generateBinaryTree(new Integer[]{0, 1, 1});
        pathSum(treeNode, 1);
    }
}
