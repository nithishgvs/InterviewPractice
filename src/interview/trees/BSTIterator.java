package interview.trees;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {


  List<TreeNode> list;

  int currentIndex = 0;

  public BSTIterator(TreeNode root) {
    list = new ArrayList<>();

    inOrder(root, list);
  }

  private void inOrder(TreeNode root, List<TreeNode> list) {
    if (root == null) {
      return;
    }
    inOrder(root.left, list);
    list.add(root);
    inOrder(root.right, list);
  }

  public int next() {
    int val = list.get(currentIndex).val;
    currentIndex++;
    return val;
  }

  public boolean hasNext() {
    return currentIndex < list.size();
  }


  public static void main(String[] args) {
    TreeNode root = new HelperTree().generateBinaryTree(new Integer[]{7, 3, 15, null, null, 9, 20});

    BSTIterator bSTIterator = new BSTIterator(root);

    System.out.println(bSTIterator.next());    // return 3
    System.out.println(bSTIterator.next());    // return 7
    System.out.println(bSTIterator.hasNext()); // return True
    System.out.println(bSTIterator.next());    // return 9
    System.out.println(bSTIterator.hasNext()); // return True
    System.out.println(bSTIterator.next());    // return 15
    System.out.println(bSTIterator.hasNext()); // return True
    System.out.println(bSTIterator.next());    // return 20
    System.out.println(bSTIterator.hasNext()); // return False

  }

}
