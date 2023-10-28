package com.practice.A_ds.F_trees;

/**
 * Created by prathapchowdary on 08/07/23.
 */
public class K_CountCompleteTreeNodes {

  //ideally in complete binary tree we will have 2^height - 1 nodes
  //1 << height - 1 = 1 * 2 ^ height - 1 [x << y = x * 2 ^ y]

  //this solution is less than O(n) because we just travel extreme left and extreme right nodes path
  // for each sub tree until we find left and right to be same
  public int countNodes(TreeNode root) {
    if(root == null) return 0;
    int height = 1;
    TreeNode left = root.left, right = root.right;
    while(left != null && right != null) {
      height++;
      left = left.left;
      right = right.right;
    }

    return left == right ? (1 << height) - 1 : 1 + countNodes(root.left) + countNodes(root.right);
  }

}
