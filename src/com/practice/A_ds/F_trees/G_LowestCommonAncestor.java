package com.practice.A_ds.F_trees;

import com.practice.C_ps.Utility;
import com.sun.source.tree.Tree;

/**
 * Created by prathap on 29/12/17.
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 */
public class G_LowestCommonAncestor {
  public static void main(String args[]) {
    //Node root = Utility.createSampleTree3();
    TreeNode root = Utility.createSampleTree();

    TreeNode p = root.left;
    TreeNode q = root.right;
    TreeNode lca = lowestCommonAncestor(root, p, q);
    System.out.print(lca.val);
  }

  /**
   * [Needs update after param data type changes to TreeNode from int]
   * Note that the above method assumes that keys are present in Binary Tree. If one key is present and other is absent, then it returns the present key as LCA (Ideally should have returned NULL).
   * We can extend this method to handle all cases by passing two boolean variables v1 and v2. v1 is set as true when n1 is present in tree and v2 is set as true if n2 is present in tree.
   *
   * To handle this case have two static boolean values to track n1, n2 found status. In the end if both booleans are true then return node else return null.
   */
  private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    if (root.val == p.val || root.val == q.val) return root;

    TreeNode l = lowestCommonAncestor(root.left, p, q);
    TreeNode r = lowestCommonAncestor(root.right, p, q);

    if (l != null && r != null) {
      return root;
    } else if (l != null) {
      return l;
    } else {
      return r;
    }
  }
}
