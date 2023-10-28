package com.practice.A_ds.F_trees;

/**
 * Created by prathapchowdary on 01/07/23.
 *
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class B_InvertBinaryTree {

    //using pre order traversal
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //using post order traversal
    public TreeNode invertTree_1(TreeNode root) {
        if (root == null)
            return null;

        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);

        root.left = r;
        root.right = l;
        return root;
    }
}
