package com.practice.A_ds.F_trees;

/**
 * Created by prathapchowdary on 11/04/22.
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 *
 */
public class H_BalancedTree {
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
