package com.practice.A_ds.F_trees;

/**
 *
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 *
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class K_SubTreeOfAnotherTree {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) return false;
    if (isSameTree(root, subRoot)) return true;
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  private boolean isSameTree(TreeNode s, TreeNode t) {
    if (s == null && t == null) return true;
    if (s == null || t == null) return false;
    return (s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right));
  }
}
