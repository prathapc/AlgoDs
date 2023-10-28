package com.practice.A_ds.F_trees;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 */
public class H_DiameterOfTree {
  static int result = 0;
  public static int diameterOfBinaryTree(TreeNode root) {
    diameter(root);
    return result;
  }

  private static int diameter(TreeNode node) {
    if (node == null) return 0;
    int l = diameter(node.left);
    int r = diameter(node.right);

    result = Math.max(result, l + r);
    return Math.max(l, r) + 1;
  }

  public static void main(String args[]) {
    System.out.println(diameterOfBinaryTree(Utility.createSampleTree()));
  }
}
