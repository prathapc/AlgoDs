package com.practice.A_ds.F_trees;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * https://leetcode.com/problems/symmetric-tree
 */
public class J_MirrorTree {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) {
      return true;
    } else if (node1 == null || node2 == null) {
      return false;
    } else {
      return (node1.val == node2.val) &&
              isSymmetric(node1.left, node2.right) &&
              isSymmetric(node1.right, node2.left);
    }
  }
}
