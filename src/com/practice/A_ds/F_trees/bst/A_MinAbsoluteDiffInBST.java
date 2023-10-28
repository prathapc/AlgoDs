package com.practice.A_ds.F_trees.bst;

import com.practice.A_ds.F_trees.TreeNode;

/**
 * Created by prathapchowdary on 08/07/23.
 *
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between
 * the values of any two different nodes in the tree.
 *
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class A_MinAbsoluteDiffInBST {

  int minDiff = Integer.MAX_VALUE;
  Integer prev = null;
  public int getMinimumDifference(TreeNode root) {
    if (root == null) {
      return minDiff;
    }

    getMinimumDifference(root.left);
    if (prev != null) {
      minDiff = Math.min(minDiff, root.val - prev);
    }
    prev = root.val;
    getMinimumDifference(root.right);

    return minDiff;
  }
}
