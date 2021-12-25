package com.practice.A_ds.F_trees;

import com.practice.B_algo.A_sort_search_math.Utility;

/**
 * https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 */
public class MaxSumPathBetweenAnyTwoNodes {

  public static void main(String args[]) {
    System.out.println(maxPathSum(Utility.createSampleTree(new String[]{"-10","9","20", null, null,"15","7"})));
  }

  public static int maxPathSum(TreeNode root) {
    int[] result = new int[1];
    result[0] = Integer.MIN_VALUE;
    maxPathSumUtil(root, result);
    return result[0];
  }

  private static int maxPathSumUtil(TreeNode root, int[] result) {
    if (root == null)
      return 0;

    int l = Math.max(maxPathSumUtil(root.left, result), 0);
    int r = Math.max(maxPathSumUtil(root.right, result), 0);
    int maxSubTree = Math.max(root.val, Math.max(l+root.val, r+root.val));
    result[0] = Math.max(l+r+root.val, result[0]);
    return maxSubTree;
  }
}
