package interview.trees;

import org.junit.Test;

public class StepByStepDirectionsFromBinaryTreeNodeToAnother_2096 {

    String startPath = "";
    String destPath = "";

    public String getDirections(TreeNode root, int startValue, int destValue) {

        TreeNode lca = lcaNode(root, startValue, destValue);

        /**
         * Nw we find 2 paths LCA to startNode and LCA to destNode
         *
         * Declare 2 strings PathtoDest and PathToDest
         */

        pathToNode(new StringBuilder(), lca, startValue, destValue);
        return "U".repeat(startPath.length()) + destPath;

    }


    private void pathToNode(StringBuilder pathSoFar, TreeNode root, int startValue, int destValue) {

        if (root == null)
            return;

        if (root.val == startValue) {
            startPath = pathSoFar.toString();
        }
        if (root.val == destValue) {
            destPath = pathSoFar.toString();
        }

        pathSoFar.append('L');
        pathToNode(pathSoFar, root.left, startValue, destValue);
        pathSoFar.setLength(pathSoFar.length() - 1);
        pathSoFar.append('R');
        pathToNode(pathSoFar, root.right, startValue, destValue);
        pathSoFar.setLength(pathSoFar.length() - 1);
    }

    private TreeNode lcaNode(TreeNode root, int startValue, int destValue) {

        if (root == null)
            return null;

        TreeNode left = lcaNode(root.left, startValue, destValue);
        TreeNode right = lcaNode(root.right, startValue, destValue);

        if (root.val == startValue || root.val == destValue)
            return root;

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    @Test

    public void test() {
        TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{1,null,10,12,13,4,6,null,15,null,null,5,11,null,2,14,7,null,8,null,null,null,9,3});

        System.out.println(getDirections(root, 6, 15));

    }
}
