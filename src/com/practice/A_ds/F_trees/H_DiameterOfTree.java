package com.practice.A_ds.F_trees;

import com.practice.C_ps.Utility;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 */
public class H_DiameterOfTree {

  public static void main(String args[]) {
    System.out.println(diameterOfBinaryTree(Utility.createSampleTree()));
  }

  public static int diameterOfBinaryTree(TreeNode root) {
    int[] result = new int[1];
    diameter(root, result);
    return result[0];
  }

  private static int diameter(TreeNode node, int[] result) {
    if (node == null) return 0;
    int l = diameter(node.left, result);
    int r = diameter(node.right, result);

    result[0] = Math.max(result[0], l + r);
    return Math.max(l, r) + 1;
  }
}
