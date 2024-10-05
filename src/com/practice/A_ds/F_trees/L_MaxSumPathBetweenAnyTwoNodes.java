package com.practice.A_ds.F_trees;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

/**
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class L_MaxSumPathBetweenAnyTwoNodes {

  int result = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    maxPathSumUtil(root);
    return result;
  }
  private int maxPathSumUtil(TreeNode root) {
    if (root == null) return 0;
    int l = maxPathSumUtil(root.left);
    int r = maxPathSumUtil(root.right);

    int maxWithOrWithoutRoot = Math.max(Math.max(l+root.val, r+root.val), root.val);

    result = Math.max(result, Math.max(maxWithOrWithoutRoot, l+r+root.val));

    return maxWithOrWithoutRoot;
  }
}
