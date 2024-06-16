package interview.metapblms;

import interview.trees.TreeNode;

public class DiameterofBinaryTree {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {


        if (root == null) {
            return 0;
        }

        helper(root);

        return diameter;

    }

    private int helper(TreeNode root) {

        if (root == null)
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }
}
