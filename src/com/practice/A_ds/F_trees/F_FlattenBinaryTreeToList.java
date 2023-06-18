package com.practice.A_ds.F_trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathapchowdary on 14/09/21.
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 *          1
 *       2    3
 *     4   5    6
 *
 *     1
 *       2
 *         3
 *           4
 *             5
 *               6
 */
public class F_FlattenBinaryTreeToList {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;

        TreeNode left = flattenTree(node.left);
        TreeNode right = flattenTree(node.right);

        if (left != null) {
            left.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return right != null ? right : left;
    }
}
