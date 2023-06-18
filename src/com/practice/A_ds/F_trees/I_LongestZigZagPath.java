package com.practice.A_ds.F_trees;

/**
 * Created by prathapchowdary on 29/04/23.
 *
 * You are given the root of a binary tree.
 *
 * A ZigZag path for a binary tree is defined as follow:
 *
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
 * Change the direction from right to left or from left to right.
 * Repeat the second and third steps until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 * 
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 */
public class I_LongestZigZagPath {
    int maxPath = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return maxPath;
    }

    private void dfs(TreeNode node, boolean goLeft, int steps) {
        if (node == null) return;
        maxPath = Math.max(maxPath, steps);
        if (goLeft) {
            dfs(node.left, false, steps+1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.right, true, steps+1);
            dfs(node.left, false, 1);
        }
    }
}
