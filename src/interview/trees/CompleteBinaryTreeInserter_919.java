package interview.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter_919 {


    class CBTInserter {

        TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
        }

        public int insert(int val) {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            TreeNode newNode = new TreeNode(val);

            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left == null) {
                    treeNode.left = newNode;
                    return treeNode.val;
                } else if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right == null) {
                    treeNode.right = newNode;
                    return treeNode.val;
                } else {
                    queue.add(treeNode.right);
                }
            }

            return -1;

        }

        public TreeNode get_root() {
            return this.root;
        }
    }
}
