package com.practice.A_ds.F_trees;

/**
 * Created by prathapchowdary on 29/11/23.
 *
 * A binary tree is uni-valued if every node in the tree has the same value.
 * Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
 *
 * Input: root = [1,1,1,1,1,null,1]
 * Output: true
 *
 * Input: root = [2,2,2,5,2]
 * Output: false
 *
 * https://leetcode.com/problems/univalued-binary-tree/
 */
public class J_UnivaluedTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return isUnivalTree(root, root.val);
    }
    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;
        return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }
}
