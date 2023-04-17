package com.practice.A_ds.F_trees;

import java.util.List;

/**
 * Created by prathap on 29/12/17.
 *
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * https://leetcode.com/problems/path-sum/
 */
public class K_SumPath {

  public boolean hasPathSum(TreeNode root, int sum) {
    if(root == null) return false;

    if(root.left == null && root.right == null && sum - root.val == 0) return true;

    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }
}
