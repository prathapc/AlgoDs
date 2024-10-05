package com.practice.A_ds.F_trees;

/**
 * Created by prathapchowdary on 09/11/23.
 *
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class H_BalancedBinaryTree {

    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return result;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);

        if (Math.abs(l-r) > 1) result = false;
        return 1+Math.max(l, r);
    }
}
