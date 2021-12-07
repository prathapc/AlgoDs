package com.practice.A_ds.F_trees;

/**
 * Created by prathapchowdary on 19/11/21.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, com.practice.A_ds.F_trees.TreeNode left, com.practice.A_ds.F_trees.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
